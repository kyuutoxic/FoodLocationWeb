/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author duonghuuthanh
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        try{
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null)
            model.addAttribute("carts", cart.values());
        else
            model.addAttribute("carts", null);
        
        model.addAttribute("cartStats", Utils.cartStats(cart));
        
        return "cart";
        }catch(Exception ex){ex.printStackTrace();}
        return "redirect:/";
    }
}
