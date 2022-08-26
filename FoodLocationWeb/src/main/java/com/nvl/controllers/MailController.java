/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;


import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import com.nvl.service.MailService;
import com.nvl.service.OrderService;
import com.nvl.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Copeoshihi
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/sendmail")
    public void sendMail(HttpSession session, @RequestBody Map<String, String> params) {
        
        String email = this.userService.getUserById(Integer.parseInt(params.get("idUser"))).getEmail();
        int type = Integer.parseInt(params.get("type"));
        List<MenuOrder> m = this.orderService.getOrderById(Integer.parseInt(params.get("idOrder")));

        this.mailService.sendEmail(type, email, m);
    }

}