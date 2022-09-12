/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import com.nvl.service.MailService;
import com.nvl.service.MomoService;
import com.nvl.service.OrderDetailService;
import com.nvl.service.OrderService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Copeoshihi
 */
@Controller
public class MomoController {

    @Autowired
    private MomoService momoService;

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private MailService mailService;

    @PostMapping("/api/momo")
    public ResponseEntity<Map<String, String>> momo(HttpSession session, @RequestBody Map<String, String> params) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        long total = Long.parseLong(params.get("total"));
        Map<String, String> result = new HashMap<>();
        Map<String, String> momoSession = new HashMap<>();
        JSONObject data = this.momoService.payment(total, cart);
        result.put("payUrl", data.get("payUrl").toString());
        Iterator<String> temp = data.getJSONObject("momoSession").keys();
        while (temp.hasNext()) {
            String key = temp.next();
            momoSession.put(key, data.getJSONObject("momoSession").get(key).toString());
        }
        session.setAttribute("momoSession", momoSession);
        if (data != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/returnmomo")
    public String returnMomo(Model model, HttpSession session, @RequestParam Map<String, String> params) {
        String resultCode = params.get("resultCode");
        Map<String, String> momoSession = (Map<String, String>) session.getAttribute("momoSession");
        if (resultCode.equals("0")
                && params.get("partnerCode").equals(momoSession.get("partnerCode"))
                && params.get("requestId").equals(momoSession.get("requestId"))
                && params.get("orderId").equals(momoSession.get("orderId"))
                && params.get("amount").equals(momoSession.get("amount"))) {
            try {
                float total = Float.parseFloat(params.get("amount"));
                String typePayment = "Momo";
                User u = (User) session.getAttribute("currentUser");
                MenuOrder m = (MenuOrder) this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u, total, typePayment);
                if (m != null) {
                    Map<String, Object> object = new HashMap<>();
                    object.put("order", this.orderDetailService.getOrderDetailByIdOrder(m.getIdOrder()));
                    this.mailService.sendEmail(1, u.getEmail(), object);
                    session.removeAttribute("cart");
                    session.removeAttribute("momoSession");
                    return "redirect:/";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        session.removeAttribute("momoSession");
        model.addAttribute("message", params.get("message"));
        model.addAttribute("errMsg", "Something went wrong, please come back later!!!");
        return "returnMomo";
    }

    @GetMapping("/notimomo")
    public String notiMomo(HttpSession session, @RequestParam Map<String, String> params) {
        return "notiMomo";
    }
}
