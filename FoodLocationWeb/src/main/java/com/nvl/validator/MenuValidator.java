/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.validator;

import com.nvl.pojo.Menu;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kyuut
 */
@Component
public class MenuValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Menu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Menu menu = (Menu) target;

        if (menu.getMenuName().isEmpty()) {
            errors.rejectValue("menuName", "Menu.menuName.Err");
        }
        if (menu.getPrice() == (float) menu.getPrice()) {
            errors.rejectValue("price", "Menu.price.Err");
        }
        if (menu.getFile().isEmpty()) {
            errors.rejectValue("file", "Menu.file.Err");
        }

    }

}
