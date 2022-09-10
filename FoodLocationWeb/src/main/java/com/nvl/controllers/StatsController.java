/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.User;
import com.nvl.service.MenuService;
import com.nvl.service.UserService;
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
public class StatsController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/stats")
    public String adminStats(Model model, @RequestParam Map<String, String> params) {

        int quarter = Integer.parseInt(params.getOrDefault("quarter", "0"));
        int month = Integer.parseInt(params.getOrDefault("month", "0"));
        int idStore = Integer.parseInt(params.getOrDefault("idStore", "0"));
        String yearText = params.getOrDefault("year", "0");
        int yearValue;
        if (yearText == "") {
            yearValue = 0;
        } else {
            yearValue = Integer.parseInt(yearText);
        }

        model.addAttribute("store", this.userService.getUserStore());
        model.addAttribute("frequency", this.menuService.frequency(quarter, month, idStore, yearValue));

        return "adminStats";
    }

    @GetMapping("/store/stats")
    public String storeStats(Model model, @RequestParam Map<String, String> params, HttpSession session) {

        int quarter = Integer.parseInt(params.getOrDefault("quarter", "0"));
        int month = Integer.parseInt(params.getOrDefault("month", "0"));
        User store = (User) session.getAttribute("currentUser");
        int idStore = store.getIdUser();
        String yearText = params.getOrDefault("year", "0");
        int yearValue;
        if (yearText == "") {
            yearValue = 0;
        } else {
            yearValue = Integer.parseInt(yearText);
        }

        model.addAttribute("revenuStats", this.menuService.total(quarter, month, idStore, yearValue));

        return "storeStats";
    }
}
