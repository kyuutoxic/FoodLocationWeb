///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nvl.controllers;
//
//import com.nvl.pojo.User;
//import com.nvl.service.UserService;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author kyuut
// */
//@RestController
//public class ApiAdminController {
//
//    @Autowired
//    private UserService userDetailsService;
//
//    @PutMapping("/admin/active-user-store/{idUser}")
//    public ResponseEntity<User> activeUser(HttpSession session) {
//        User u = (User) session.getAttribute("userStore");
//
//        if (this.userDetailsService.activeUserStore(u) == true) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//}
