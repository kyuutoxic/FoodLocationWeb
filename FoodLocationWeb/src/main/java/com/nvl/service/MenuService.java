/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Menu;
import com.nvl.pojo.Type;
import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface MenuService {
    List<Menu> getMenu();

    boolean addMenu(Menu menu, User user);
}
