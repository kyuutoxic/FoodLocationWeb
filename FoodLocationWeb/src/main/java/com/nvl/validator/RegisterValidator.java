/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.validator;

import com.nvl.pojo.User;
import com.nvl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kyuut
 */
@Component
public class RegisterValidator implements Validator{

    @Autowired
    private UserService userDetailsService;
    
    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
        if( !u.getUsername().isEmpty() && !this.userDetailsService.getUser(u.getUsername()).isEmpty()){
            errors.rejectValue("username", "user.userName.Err");
        }
        if(u.getUsername().isEmpty()){
            errors.rejectValue("username", "user.userName1.Err");
        }
        if(u.getPassword().isEmpty()){
            errors.rejectValue("password", "user.password.Err");
        }
        if(u.getFirstName().isEmpty()){
            errors.rejectValue("firstName", "user.firstName.Err");
        }
        if(u.getLastName().isEmpty()){
            errors.rejectValue("lastName", "user.lastName.Err");
        }
        if(!u.getPhone().isEmpty() && !this.userDetailsService.checkPhone(u.getPhone()).isEmpty()){
            errors.rejectValue("phone", "user.phone.Err");
        }
        if(!u.getEmail().isEmpty() && !this.userDetailsService.checkEmail(u.getEmail()).isEmpty()){
            errors.rejectValue("email", "user.email.Err");
        }
        if(u.getPhone().isEmpty()){
            errors.rejectValue("phone", "user.phone1.Err");
        }
        if(u.getEmail().isEmpty()){
            errors.rejectValue("email", "user.email1.Err");
        }
        if(u.getConfirmPassword().isEmpty()){
            errors.rejectValue("confirmPassword", "user.confirmPassword1.Err");
        }
        if(u.getFile().isEmpty()){
            errors.rejectValue("file", "user.file.Err");
        }
    }
    
}
