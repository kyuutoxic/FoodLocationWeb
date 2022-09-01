/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Copeoshihi
 */
@Controller
public class PaymentController {
    @GetMapping("/payment/{type}")
    public String cart(Model model, HttpSession session, @PathVariable(value = "type") String type) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null)
            model.addAttribute("carts", cart.values());
        else
            model.addAttribute("carts", null);
        
        model.addAttribute("cartStats", Utils.cartStats(cart));
        model.addAttribute("type", type);
        
        return "payment";
    }
}
