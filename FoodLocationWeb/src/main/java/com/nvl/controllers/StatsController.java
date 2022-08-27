/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.service.MenuService;
import com.nvl.service.UserService;
import java.util.Map;
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
public class StatsController {    
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/admin/stats")
    public String stats(Model model, @RequestParam Map<String,String> params) {
    
        int quarter = Integer.parseInt(params.getOrDefault("quarter", "0"));
        int month = Integer.parseInt(params.getOrDefault("month", "0"));
        int idStore = Integer.parseInt(params.getOrDefault("idStore", "0"));
        int year = Integer.parseInt(params.getOrDefault("year", "2022"));
             
        model.addAttribute("store", this.userService.getUserStore());
        model.addAttribute("frequency", this.menuService.frequency(quarter, month, idStore, year));
        model.addAttribute("revenuStats", this.menuService.total(quarter, month, idStore, year));
        
        return "adminStats";
    }
}
