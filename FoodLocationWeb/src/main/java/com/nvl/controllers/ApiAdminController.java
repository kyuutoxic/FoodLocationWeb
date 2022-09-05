/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Menu;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import com.nvl.service.OrderDetailService;
import com.nvl.service.OrderService;
import com.nvl.service.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyuut
 */
@RestController
public class ApiAdminController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userDetailsService;

    @PostMapping("/api/change-delete/{idMenu}")
    public ResponseEntity<Menu> deteleMenu(@PathVariable(value = "idMenu") int idMenu, HttpSession session) {

        if (this.menuService.changeMenuIsDelete(idMenu) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    
    @PostMapping("/api/change-delete-user/{idUser}")
    public ResponseEntity<User> deteleUser(@PathVariable(value = "idUser") int idUser, HttpSession session) {

        if (this.userDetailsService.changeIsDelete(idUser) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    
    @PostMapping("/api/change-active-store/{idStore}")
    public ResponseEntity<User> activeStore(@PathVariable(value = "idStore") int idStore, HttpSession session) {

        if (this.userDetailsService.changeActive(idStore) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/api/admin/orderdetail/")
    public ResponseEntity<List<OrderDetail>> getOrderDetail(HttpSession session) {
        return new ResponseEntity<>(this.orderDetailService.getOrderDetail(-1), HttpStatus.OK);
    }

    @GetMapping("/api/admin/order/")
    public ResponseEntity<List<MenuOrder>> getOrder(HttpSession session) {
        return new ResponseEntity<>(this.orderService.getOrder(), HttpStatus.OK);
    }
    
    @GetMapping("/api/admin/users/")
    public ResponseEntity<List<User>> getUsers(HttpSession session) {
        return new ResponseEntity<>(this.userDetailsService.manageUser(), HttpStatus.OK);
    }
    
    @GetMapping("/api/admin/store/")
    public ResponseEntity<List<User>> getStores(HttpSession session) {
        return new ResponseEntity<>(this.userDetailsService.manageStore(), HttpStatus.OK);
    }
}
