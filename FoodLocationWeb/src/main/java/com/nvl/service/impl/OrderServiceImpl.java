/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.service.impl;

import com.nvl.pojo.Cart;
import com.nvl.pojo.User;
import com.nvl.repository.OrderRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghuuthanh
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart, int idUser) {
        User u = (User) this.userRepository.getUserById(idUser);
        if (cart != null)
            return this.orderRepository.addReceipt(cart,u);
        
        return false;
    }

}
