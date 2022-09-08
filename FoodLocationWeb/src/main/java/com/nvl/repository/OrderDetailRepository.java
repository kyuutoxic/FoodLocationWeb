/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.OrderDetail;
import java.util.List;

/**
 *
 * @author Copeoshihi
 */
public interface OrderDetailRepository {
    
    List<Object[]> getOrderDetailByIdStore(int idStore);
    
    boolean acceptOrder(int idOrderDetail);
    
    OrderDetail denyOrder(int idOrderDetail);
    
    List<OrderDetail> getOrderDetail(int idStore);
    
    List<OrderDetail> getOrderDetailByIdOrder(int idOrder);
    
}
