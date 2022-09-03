/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.pojo.Menu;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import com.nvl.service.OrderService;
import com.nvl.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Copeoshihi
 */
@RestController
@RequestMapping("/api")
public class ApiPaymentController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private MenuService menuService;

    @PostMapping("/pay")
    public ResponseEntity<List<MenuOrder>> pay(HttpSession session, @RequestBody Map<String, String> params) {
        float total = Float.parseFloat(params.get("total"));
        String typePayment = (String) params.get("type");

        List<MenuOrder> menuOrder = new ArrayList<>();
        User u = (User) session.getAttribute("currentUser");
        MenuOrder m = (MenuOrder) this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u, total, typePayment);
        if (m != null) {
            menuOrder.add(m);
            session.removeAttribute("cart");
            System.out.println(typePayment + "HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            return new ResponseEntity<>(menuOrder, HttpStatus.OK);
        }

        return new ResponseEntity<>(menuOrder, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/storeInCart")
    public ResponseEntity<List<User>> storeInCart(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        List<User> store = new ArrayList<>();
        cart.forEach((k, v) -> {
            Menu m = this.menuService.getMenuById(v.getMenuId());
            User u = this.userDetailsService.getUserById(m.getIdStore().getIdUser());
            if (!store.contains(u)) {
                store.add(u);
            }
        });
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @GetMapping("/storeByMenuID/{idMenu}")
    public ResponseEntity<List<User>> storeByMenuID(HttpSession session, @PathVariable(value = "idMenu") int idMenu) {
        List<User> store = new ArrayList<>();
        Menu m = this.menuService.getMenuById(idMenu);
        User u = this.userDetailsService.getUserById(m.getIdStore().getIdUser());
        store.add(u);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}
