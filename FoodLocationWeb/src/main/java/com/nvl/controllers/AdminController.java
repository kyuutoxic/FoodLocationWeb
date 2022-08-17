/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.User;
import com.nvl.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author kyuut
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/admin")
    public String adminView(Model model) {
        model.addAttribute("userStore", this.userDetailsService.getUserStore());

        return "admin";
    }

    @GetMapping("/admin/active-user-store/{idUser}")
    public String activeView(Model model, @PathVariable(value = "idUser") int idUser) {
        model.addAttribute("userStore", this.userDetailsService.getUserById(idUser));

        return "activeUserStore";
    }

    @PostMapping("/admin/active-user-store/{idUser}")
    public String active(Model model, @PathVariable(value = "idUser") int idUser, HttpSession session) {
        if (this.userDetailsService.activeUserStore(idUser) == true) {
            return "redirect:/admin";
        }
        return "activeUserStore";
    }
}
