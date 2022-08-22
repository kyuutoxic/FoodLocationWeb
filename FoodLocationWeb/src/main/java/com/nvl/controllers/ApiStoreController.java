/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.User;
import com.nvl.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/store")
    public ResponseEntity<List<User>> getStore() {
        return new ResponseEntity<>(this.userDetailsService.getUserStore(), HttpStatus.OK);
    }
    
    @GetMapping("/order-store")
    public ResponseEntity<List<User>> getOrder() {
        return new ResponseEntity<>(this.userDetailsService.getUserStore(), HttpStatus.OK);
    }
}
