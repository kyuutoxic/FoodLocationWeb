/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.utils;

import com.nvl.pojo.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kyuut
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart) {
        int q = 0;
        
        if (cart != null)
            for (Cart c: cart.values())
                q += c.getQuantity();
        
        return q;
    }
    
    public static Map<String, String> cartStats(Map<Integer, Cart> cart) {
        Long s = 0l;
        int q = 0;
        
        if (cart != null)
            for (Cart c: cart.values()) {
                q += c.getQuantity();
                s += c.getQuantity() * c.getPrice();
            }
        
        Map<String, String> kq = new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("amount", String.valueOf(s));
        
        
        return kq;
    }
}
