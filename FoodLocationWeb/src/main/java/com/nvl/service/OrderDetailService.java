/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.OrderDetail;
import java.util.List;

/**
 *
 * @author Copeoshihi
 */
public interface OrderDetailService {
    
    List<Object[]> getOrderDetailByIdStore(int idStore);
    
    boolean acceptOrder(int idOrderDetail);
    
    boolean denyOrder(int idOrderDetail);
    
    List<OrderDetail> getOrderDetail(int idStore);
}
