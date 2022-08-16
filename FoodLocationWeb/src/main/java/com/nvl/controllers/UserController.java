/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.User;
import com.nvl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/choose-register")
    public String chooserRegisterView(Model model) {
        return "chooseRegister";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty() 
                || !user.getPassword().equals(user.getConfirmPassword())) 
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        else {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            }
            
            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }
        
        return "register";
    }
}
