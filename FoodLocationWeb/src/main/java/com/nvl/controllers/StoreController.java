/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import com.nvl.service.TypeService;
import com.nvl.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Copeoshihi
 */
@Controller
public class StoreController {
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/store")
    public String storeView(Model model) {
        model.addAttribute("userStore", this.userDetailsService.getUserStoreNotActive());

        return "store";
    }
    
    @GetMapping("/store/menu")
    public String storeMenuView() {
        return "storeMenuView";
    }
    
    @GetMapping("/store/add-menu")
    public String addMenuView(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("type", this.typeService.getType());

        return "storeAddMenuView";
    }

    @PostMapping(value = "/store/add-menu")
    public String addMenu(@ModelAttribute(value = "menu") Menu menu, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (this.menuService.addMenu(menu, u) == true) {
            return "redirect:/store/menu";
        }

        return "storeAddMenuView";
    }
    
    @GetMapping("/store/detail-menu/{idMenu}")
    public String detailMenuView(Model model, @PathVariable(value = "idMenu") int idMenu) {
//        khuc nay phai chan thang store nay coi store khac(lay cai idMenu ma trung voi id menu cua store hien tai moi cho vao)
        model.addAttribute("menu", this.menuService.getMenuById(idMenu));
        model.addAttribute("type", this.typeService.getType());
        return "detailMenu";
    }

    @PostMapping(value = "/store/detail-menu/{idMenu}")
    public String detailMenu(Model model, @PathVariable(value = "idMenu") int idMenu, HttpSession session) {
//        User u = (User) session.getAttribute("currentUser");
//        if (this.menuService.addMenu(menu, u) == true) {
//            return "redirect:/admin/menu";
//        }

        return "detailMenu";
    }
    
}
