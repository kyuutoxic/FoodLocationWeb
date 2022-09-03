/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.service.impl;

import com.nvl.pojo.Cart;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import com.nvl.repository.OrderRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.OrderService;
import java.util.List;
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

    @Override
    public MenuOrder addReceipt(Map<Integer, Cart> cart, User user, float total, String type) {
        return this.orderRepository.addReceipt(cart,user,total,type);
    }

    @Override
    public List<MenuOrder> getOrderById(int idOrder) {
        return this.orderRepository.getOrder(idOrder);
    }

    @Override
    public List<MenuOrder> getOrderByIdOrderDetail(int idOrderDetail) {
        return this.orderRepository.getOrderByIdOrderDetail(idOrderDetail);
    }

}
