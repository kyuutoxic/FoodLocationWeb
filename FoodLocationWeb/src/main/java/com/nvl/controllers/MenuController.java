/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.service.MenuService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Copeoshihi
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;
    
    @GetMapping("/menu")
    public String menuView(Model model,
            @RequestParam(required = false) Map<String, String> params,
            HttpSession session) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String sort = params.get("sort");
        String type = params.getOrDefault("type", null);
        model.addAttribute("products", this.menuService.getMenus(kw, page, sort, type));
        model.addAttribute("productCounter", this.menuService.countMenu(kw));
        return "menu";
    }
}
