/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kyuut
 */
public interface MenuRepository {

    boolean addMenu(Menu menu);

    List<Menu> getMenus(Map<String, String> params, int page);

    List<Menu> getMenuByIdStore(User Store);

    Menu getMenuById(int idMenu);

    int countMenu();
}
