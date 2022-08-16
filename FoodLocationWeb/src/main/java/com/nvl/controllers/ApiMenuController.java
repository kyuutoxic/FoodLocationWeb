///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nvl.controllers;
//
//import com.nvl.pojo.Menu;
//import com.nvl.repository.MenuRepository;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author kyuut
// */
//@RestController
//@RequestMapping("/api")
//public class ApiMenuController {
//    @Autowired
//    private MenuRepository menuRepository;
//    
//    GetMapping("/menu")
//    public ResponseEntity<List<Menu>> getMenu() {
//        return new ResponseEntity<>(this.menuRepository.getMenu(), HttpStatus.OK);
//    }
//}
