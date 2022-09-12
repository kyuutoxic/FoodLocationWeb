package com.nvl.controllers;

import com.nvl.repository.CommentRepository;
import com.nvl.service.MenuService;
import com.nvl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StoreCController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/storec/{idStore}")
    public String product(Model model, @PathVariable(value = "idStore") int idStore) {
        model.addAttribute("store", this.userDetailsService.getUserById(idStore));
        model.addAttribute("menu", this.menuService.getMenuByIdStore(idStore));
        model.addAttribute("comments", this.commentRepository.getCommentByStoreId(idStore));
        model.addAttribute("countComments", this.userDetailsService.countComments(idStore));
        model.addAttribute("countRatings", this.userDetailsService.countRatings(idStore));

        return "storec";
    }
}
