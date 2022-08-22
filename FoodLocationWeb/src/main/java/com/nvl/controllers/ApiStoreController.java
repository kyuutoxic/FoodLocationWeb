/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.User;
import com.nvl.service.OrderDetailService;
import com.nvl.service.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyuut
 */
@RestController
@RequestMapping("/api")
public class ApiStoreController {
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private OrderDetailService orderDetailService;
    
    @GetMapping("/store")
    public ResponseEntity<List<User>> getStore() {
        return new ResponseEntity<>(this.userDetailsService.getUserStore(), HttpStatus.OK);
    }
    
    @GetMapping("/store/order")
    public ResponseEntity<List<Object[]>> getOrder(HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        return new ResponseEntity<>(this.orderDetailService.getOrderDetailByIdStore(u.getIdUser()), HttpStatus.OK);
    }
    
    @GetMapping("/store/accept/{idOrderDetail}")
    public boolean acceptOrderDetail(@PathVariable(value = "idOrderDetail") int idOrderDetail) {
        return this.orderDetailService.acceptOrder(idOrderDetail);
    }
    
    @GetMapping("/store/deny/{idOrderDetail}")
    public boolean denyOrderDetail(@PathVariable(value = "idOrderDetail") int idOrderDetail) {
        return this.orderDetailService.denyOrder(idOrderDetail);
    }
}
