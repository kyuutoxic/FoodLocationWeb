/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;


import com.nvl.pojo.OrderDetail;
import com.nvl.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Copeoshihi
 */
@RestController
public class MailController {
    
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/orderDetail/{idOrder}")
    public ResponseEntity<List<OrderDetail>> getOrder(@PathVariable(value = "idOrder") int idOrder) {
        return new ResponseEntity<>(this.orderDetailService.getOrderDetailByIdOrder(idOrder), HttpStatus.OK);
    }

}