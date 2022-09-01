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
import com.nvl.service.OrderService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    private MailService mailService;
    
    @PostMapping("/api/momo")
    public ResponseEntity<Map<String, String>> momo(HttpSession session, @RequestBody Map<String, String> params) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        long total = Long.parseLong(params.get("total"));
        Map<String, String> result = new HashMap<>();
        JSONObject data = this.momoService.payment(total, cart);
        Iterator<String> temp = data.keys();
        while (temp.hasNext()) {
            String key = temp.next();
            result.put(key, data.get(key).toString());
        }
        if(data != null){
            System.out.println(result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/returnmomo")
    public String returnMomo(Model model, HttpSession session, @RequestParam Map<String, String> params) {
        float total = Float.parseFloat(params.get("amount"));
        String resultCode = params.get("resultCode");
        model.addAttribute("message", params.get("message"));
        if(resultCode == "0"){
            List<MenuOrder> menuOrder = new ArrayList<>();
            User u = (User) session.getAttribute("currentUser");
            MenuOrder m = (MenuOrder)this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u, total);
            Map<String, Object> object = new HashMap<>();
            object.put("order", m);
            if (m != null) {
                menuOrder.add(m);
                this.mailService.sendEmail(1, u.getEmail(), object);
                session.removeAttribute("cart");
                return "returnMomo";
            }
        }
        return "returnMomo";
    }
    
    @GetMapping("/notimomo")
    public String notiMomo() {
        return "notiMomo";
    }
}
