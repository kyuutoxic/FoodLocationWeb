/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Cart;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author Copeoshihi
 */
public interface MomoService {
    JSONObject payment(long total, Map<Integer, Cart> cart);
}
