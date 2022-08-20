/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Cart;
import com.nvl.pojo.Menu;
import static com.nvl.pojo.Menu_.idStore;
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
public class PaymentApiController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private MenuService menuService;
    
    @PostMapping("/pay/{total}")
    public HttpStatus pay(HttpSession session, @PathVariable(value = "total") float total) {
        User u = (User) session.getAttribute("currentUser");
        if (this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u, total) == true) {
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
        
        return HttpStatus.BAD_REQUEST;
    }
    
    @GetMapping("/storeInCart")
    public ResponseEntity<List<User>> storeInCart(HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        List<User> store = new ArrayList<>();
        cart.forEach((k,v) -> {
            Menu m = this.menuService.getMenuById(v.getMenuId());
            User u = this.userDetailsService.getUserById(m.getIdStore().getIdUser());
            if(!store.contains(u)){
                store.add(u);
            }
        });
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
    
    @GetMapping("/storeByMenuID/{idMenu}")
    public ResponseEntity<List<User>> storeByMenuID(HttpSession session,  @PathVariable(value = "idMenu") int idMenu){
        List<User> store = new ArrayList<>();
        Menu m = this.menuService.getMenuById(idMenu);
        User u = this.userDetailsService.getUserById(m.getIdStore().getIdUser());
        store.add(u);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}
