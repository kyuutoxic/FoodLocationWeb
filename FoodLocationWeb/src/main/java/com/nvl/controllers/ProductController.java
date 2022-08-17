package com.nvl.controllers;
import com.nvl.service.MenuService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/menu")
    public String product(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("menus", this.menuService.getMenus(params, page));
        model.addAttribute("menuCounter", this.menuService.countMenu());
        return "menu";
    }
}