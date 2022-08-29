/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Follow;
import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import com.nvl.service.FollowService;
import com.nvl.service.MailService;
import com.nvl.service.MenuService;
import com.nvl.service.TypeService;
import com.nvl.service.UserService;
<<<<<<< HEAD
import com.nvl.validator.WebAppValidator;
=======
import com.nvl.validator.MenuValidator;
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Copeoshihi
 */
@Controller
public class StoreController {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MailService mailService;

    @Autowired
    private FollowService followService;
<<<<<<< HEAD
    
    @Autowired
    private WebAppValidator menuValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(menuValidator);
    }
    
=======

>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
    @GetMapping("/store")

    public String storeView(Model model, HttpSession session) {
        User store = (User) session.getAttribute("currentUser");
        model.addAttribute("userStore", this.userDetailsService.getUserStoreNotActive());
        model.addAttribute("statsStore", this.menuService.statsStore(store.getIdUser()));
        return "store";
    }

    @GetMapping("/store/menu")
    public String storeMenuView() {
        return "storeMenuView";
    }

    @GetMapping("/store/add-menu")
    public String addMenuView(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("type", this.typeService.getType());

        return "storeAddMenuView";
    }

<<<<<<< HEAD
    @PostMapping("/store/add-menu")
    public String addMenu(Model model, @ModelAttribute(value = "menu") @Valid Menu menu, BindingResult result, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (!result.hasErrors()){
            if (this.menuService.addMenu(menu, u) == true) {
                List<Follow> follow = this.followService.getFollowByIdStore(u);
                follow.forEach(f -> {
                    this.mailService.sendEmail(3, f.getIdUser().getEmail(), null);
                    System.out.println(f.getIdUser().getEmail());
                });
                return "redirect:/store/menu";
            }
=======
    @PostMapping(value = "/store/add-menu")
    public String addMenu(@ModelAttribute(value = "menu") Menu menu, HttpSession session, BindingResult result) {
        User u = (User) session.getAttribute("currentUser");

        if (this.menuService.addMenu(menu, u) == true) {
            List<Follow> follow = this.followService.getFollowByIdStore(u);
            follow.forEach(f -> {
                this.mailService.sendEmail(3, f.getIdUser().getEmail(), null);
                System.out.println(f.getIdUser().getEmail());
            });
            return "redirect:/store/menu";
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
        }
        return "storeAddMenuView";
    }

    @GetMapping("/store/detail-menu/{idMenu}")
    public String detailMenuView(Model model, @PathVariable(value = "idMenu") int idMenu) {
//        khuc nay phai chan thang store nay coi store khac(lay cai idMenu ma trung voi id menu cua store hien tai moi cho vao)
        model.addAttribute("menu", this.menuService.getMenuById(idMenu));
        model.addAttribute("type", this.typeService.getType());
        return "storeDetailMenu";
    }

    @PostMapping("/store/detail-menu/{idMenu}")
    public String detailMenu(Model model, @PathVariable(value = "idMenu") int idMenu, HttpSession session) {
//        User u = (User) session.getAttribute("currentUser");
//        if (this.menuService.addMenu(menu, u) == true) {
//            return "redirect:/admin/menu";
//        }

        return "storeDetailMenu";
    }

    @GetMapping("/store/account-store/")
    public String storeAccountView(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("user", u);
        return "accountStore";
    }

    @PostMapping("/store/account-store/")
    public String storeAccount(Model model, @ModelAttribute(value = "user") User user, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");

        if (this.userDetailsService.updateUser(u.getIdUser(), user) == true) {
            session.setAttribute("currentUser", this.userDetailsService.getUserById(u.getIdUser()));
            return "redirect:/store";
        }

        return "redirect:/account-store/";
    }

}
