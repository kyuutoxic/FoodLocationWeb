/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.configs.handlers;

import com.nvl.pojo.User;
import com.nvl.service.UserService;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Admin
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Autowired
    private UserService userDetailsService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
       User user = this.userDetailsService.getUser(a.getName()).get(0);
       if(user.getActive() == Boolean.TRUE){
           request.getSession().setAttribute("currentUser", user);
//           response.sendRedirect("/FoodLocationWeb");
           if(Objects.equals(user.getUserRole(), "ROLE_ADMIN")){
               response.sendRedirect("/FoodLocationWeb/admin/");
           } else if (Objects.equals(user.getUserRole(),"ROLE_STORE")){
               response.sendRedirect("/FoodLocationWeb/store/");
           } else if (Objects.equals(user.getUserRole(), "ROLE_USER")) {
               response.sendRedirect("/FoodLocationWeb/");
           }
       } else {
           response.sendRedirect("/FoodLocationWeb/login?error");
       }
    }
    
}
