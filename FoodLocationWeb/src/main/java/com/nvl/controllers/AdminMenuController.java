/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Menu;
import com.nvl.service.MenuService;
import com.nvl.service.TypeService;
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
    public String adminMenuView() {
        return "adminMenuView";
    }

    @GetMapping("/admin/detail-menu/{idMenu}")
    public String detailMenuView(Model model, @PathVariable(value = "idMenu") int idMenu) {
        model.addAttribute("menu", this.menuService.getMenuById(idMenu));
        model.addAttribute("type", this.typeService.getType());
        return "adminDetailMenu";
    }

    @PostMapping(value = "/admin/detail-menu/{idMenu}")
    public String detailMenu(@ModelAttribute(value = "menu") Menu menu) {
        if (this.menuService.updateMenu(menu.getIdMenu(), menu) == true) {
            return "redirect:/admin/menu";
        }
        return "adminDetailMenu";

    }
}
