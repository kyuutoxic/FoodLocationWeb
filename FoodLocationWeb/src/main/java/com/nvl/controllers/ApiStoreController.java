/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.User;
import com.nvl.service.MailService;
import com.nvl.service.OrderDetailService;
import com.nvl.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @Autowired
    private MailService mailService;
    
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
    public ResponseEntity<List<MenuOrder>> denyOrderDetail(@PathVariable(value = "idOrderDetail") int idOrderDetail) {

        OrderDetail m = this.orderDetailService.denyOrder(idOrderDetail);
                
        if(m != null){
            Map<String, Object> object = new HashMap<>();
            object.put("order", m);
            this.mailService.sendEmail(2, m.getIdOrder().getIdUser().getEmail(), object);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
