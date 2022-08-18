package com.nvl.controllers;

import com.nvl.service.MenuService;
import com.nvl.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreCController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/storec/{idStore}")
    public String product(Model model, @PathVariable(value = "idStore") int idStore) {
        model.addAttribute("store", this.userDetailsService.getUserById(idStore));
        model.addAttribute("menu", this.menuService.getMenuByIdStore(idStore));
        return "storec";
    }
}
