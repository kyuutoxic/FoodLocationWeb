/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.OrderDetail;
import com.nvl.service.OrderDetailService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Copeoshihi
 */
@RestController
@RequestMapping("/api")
public class ApiOrderDetailController {
    
    @Autowired
    private OrderDetailService orderDetailService;
    
    @GetMapping("/orderDetail")
    public ResponseEntity<List<OrderDetail>> getOrderDetail(@RequestBody Map<String, String> params) {
        return new ResponseEntity<>(this.orderDetailService.getOrderDetail(Integer.parseInt(params.get("idStore"))), HttpStatus.OK);
    }
    
}
