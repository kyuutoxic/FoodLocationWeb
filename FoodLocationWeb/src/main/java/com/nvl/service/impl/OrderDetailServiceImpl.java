/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.nvl.pojo.OrderDetail;
import com.nvl.repository.OrderDetailRepository;
import com.nvl.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Copeoshihi
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Object[]> getOrderDetailByIdStore(int idStore) {
        return this.orderDetailRepository.getOrderDetailByIdStore(idStore);
    }

    @Override
    public boolean acceptOrder(int idOrderDetail) {
        return this.orderDetailRepository.acceptOrder(idOrderDetail);
    }

    @Override
    public boolean denyOrder(int idOrderDetail) {
        return this.orderDetailRepository.denyOrder(idOrderDetail);
    }

    @Override
    public List<OrderDetail> getOrderDetail(int idStore) {
        return this.orderDetailRepository.getOrderDetail(idStore);
    }
    
}
