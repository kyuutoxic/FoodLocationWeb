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
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        } else {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            }

            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }

        return "register";
    }

    @GetMapping("/register-store")
    public String registerStoreView(Model model) {
        model.addAttribute("user", new User());
        return "registerStore";
    }

    @PostMapping("/register-store")
    public String registerStore(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        } else {
            if (this.userDetailsService.addUserStore(user) == true) {
                return "redirect:/login";
            }

            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }

        return "registerStore";
    }

    @GetMapping("/account-user/{idUser}")
    public String myAccountView(Model model, @PathVariable(value = "idUser") int idUser, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("user", u);
        return "accountUser";
    }

    @PostMapping("/account-user/{idUser}")
    public String myAccount(Model model, @PathVariable(value = "idUser") int idUser, HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (this.userDetailsService.updateUser(idUser, u) == true) {
            return "redirect:/";
        }

        return "accountUser";
    }

}
