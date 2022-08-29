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
public class RegisterValidator implements Validator {

    @Autowired
<<<<<<< HEAD
    private UserService userService;
    
=======
    private UserService userDetailsService;

>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
<<<<<<< HEAD
        if( !u.getUsername().isEmpty() && !this.userService.getUser(u.getUsername()).isEmpty()){
=======
        if (!u.getUsername().isEmpty() && !this.userDetailsService.getUser(u.getUsername()).isEmpty()) {
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
            errors.rejectValue("username", "user.userName.Err");
        }
        if (u.getUsername().isEmpty()) {
            errors.rejectValue("username", "user.userName1.Err");
        }
        if (u.getPassword().isEmpty()) {
            errors.rejectValue("password", "user.password.Err");
        }
        if (u.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "user.firstName.Err");
        }
        if (u.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "user.lastName.Err");
        }
<<<<<<< HEAD
        if(!u.getPhone().isEmpty() && !this.userService.checkPhone(u.getPhone()).isEmpty()){
            errors.rejectValue("phone", "user.phone.Err");
        }
        if(!u.getEmail().isEmpty() && !this.userService.checkEmail(u.getEmail()).isEmpty()){
=======
        if (!u.getPhone().isEmpty() && !this.userDetailsService.checkPhone(u.getPhone()).isEmpty()) {
            errors.rejectValue("phone", "user.phone.Err");
        }
        if (!u.getEmail().isEmpty() && !this.userDetailsService.checkEmail(u.getEmail()).isEmpty()) {
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
            errors.rejectValue("email", "user.email.Err");
        }
        if (u.getPhone().isEmpty()) {
            errors.rejectValue("phone", "user.phone1.Err");
        }
        if (u.getEmail().isEmpty()) {
            errors.rejectValue("email", "user.email1.Err");
        }
        if (u.getConfirmPassword().isEmpty()) {
            errors.rejectValue("confirmPassword", "user.confirmPassword1.Err");
        }
        if (u.getFile().isEmpty()) {
            errors.rejectValue("file", "user.file.Err");
        }
    }

}
