/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import com.nvl.service.TypeService;
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
 * @author kyuut
 */
@Controller
public class AdminMenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/admin/menu")
    public String menuView() {
        return "adminMenuView";
    }

    @GetMapping("/admin/add-menu")
    public String addMenuView(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("type", this.typeService.getType());

        return "adminAddMenuView";
    }

    @PostMapping(value = "/admin/add-menu")
    public String addMenu(@ModelAttribute(value = "menu") Menu menu, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (this.menuService.addMenu(menu, u) == true) {
            return "redirect:/admin/menu";
        }

        return "adminAddMenuView";
    }

    @GetMapping("/admin/detail-menu/{idMenu}")
    public String detailMenuView(Model model, @PathVariable(value = "idMenu") int idMenu) {
        model.addAttribute("menu", this.menuService.getMenuById(idMenu));
        model.addAttribute("type", this.typeService.getType());
        return "detailMenu";
    }

    @PostMapping(value = "/admin/detail-menu/{idMenu}")
    public String detailMenu(Model model, @PathVariable(value = "idMenu") int idMenu, HttpSession session) {
//        User u = (User) session.getAttribute("currentUser");
//        if (this.menuService.addMenu(menu, u) == true) {
//            return "redirect:/admin/menu";
//        }

        return "detailMenu";
    }
}
