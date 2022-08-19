/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.service.OrderService;
import com.nvl.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duonghuuthanh
 */
@RestController
public class ApiCartController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null)
            cart = new HashMap<>();
        
        int productId = params.getMenuId();
        if (cart.containsKey(productId) == true) { // san pham da co trong gio
            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else { // san pham chua co trong gio
            cart.put(productId, params);
        }
        
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    
    @PutMapping("/api/cart")
    public ResponseEntity<Map<String, String>> updateCartItem(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null)
            cart = new HashMap<>();
        
        int productId = params.getMenuId();
        if (cart.containsKey(productId) == true) { // san pham da co trong gio
            Cart c = cart.get(productId);
            c.setQuantity(params.getQuantity());
        }
        
        session.setAttribute("cart", cart);
        
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }
//    
    @DeleteMapping("/api/cart/{menuId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "menuId") int menuId,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(menuId)) {
            cart.remove(menuId);
            
            session.setAttribute("cart", cart);
        }
        
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }
//    
//    @PostMapping("/api/pay")
//    public HttpStatus pay(HttpSession session) {
//        if (this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart")) == true) {
//            session.removeAttribute("cart");
//            return HttpStatus.OK;
//        }
//        
//        return HttpStatus.BAD_REQUEST;
//    }
}
