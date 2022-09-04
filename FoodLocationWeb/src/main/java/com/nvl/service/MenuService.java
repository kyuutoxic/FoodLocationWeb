/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface MenuService {

    List<Menu> getMenus(String kw, int page, String sort, String type);

    int countMenu(String kw);

    Menu getMenuById(int idMenu);

    boolean addMenu(Menu menu, User user);

    List<Menu> getMenuByIdStore(int idStore);

    List<Object> frequency(int quarter, int month, int idStore, int year);

    List<Object> total(int quarter, int month, int idStore, int year);

    List<Object> statsStore(int idStore);

    boolean updateMenu(int idMenu, Menu menu);
    
    boolean checkStoreByMenuId(int idMenu, User user);
    
    boolean changeMenuIsDelete(int idMenu);
    
    List<Menu> manageMenu();
}
