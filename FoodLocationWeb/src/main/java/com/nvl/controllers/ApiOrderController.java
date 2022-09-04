/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.MenuOrder;
import com.nvl.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Copeoshihi
 */
@RestController
@RequestMapping("/api")
public class ApiOrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/order")
    public ResponseEntity<List<MenuOrder>> getOrder() {
        return new ResponseEntity<>(this.orderService.getOrder(), HttpStatus.OK);
    }
    
}
