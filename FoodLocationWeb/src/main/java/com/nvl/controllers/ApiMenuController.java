/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyuut
 */
@RestController
@RequestMapping("/api")
public class ApiMenuController {
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getMenu() {
        return new ResponseEntity<>(this.menuService.getMenus(null, 0), HttpStatus.OK);
    }
    
    @GetMapping("/store/menu")
    public ResponseEntity<List<Menu>> getStoreMenu(HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        return new ResponseEntity<>(this.menuService.getMenuByIdStore(u.getIdUser()), HttpStatus.OK);
    }
}
