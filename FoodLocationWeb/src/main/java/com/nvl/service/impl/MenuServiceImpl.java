/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nvl.pojo.Menu;
import com.nvl.pojo.Type;
import com.nvl.pojo.User;
import com.nvl.repository.MenuRepository;
import com.nvl.repository.TypeRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.MenuService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyuut
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Menu> getMenus(Map<String, String> params, int page) {
        return this.menuRepository.getMenus(params, page);
    }

    @Override
    public int countMenu() {
        return this.menuRepository.countMenu();
    }

    @Override
    public boolean addMenu(Menu menu, User user) {
        Type t = this.typeRepository.getTypeById(menu.getTypeId());
        try {
            menu.setMenuStatus(Boolean.TRUE);
            menu.setCreatedDate(new Date());
            menu.setUpdateDate(new Date());
            menu.setIdType(t);
            menu.setIdStore(user);

            Map r = this.cloudinary.uploader().upload(menu.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            menu.setImage((String) r.get("secure_url"));

            return this.menuRepository.addMenu(menu);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Menu getMenuById(int idMenu) {
        return this.menuRepository.getMenuById(idMenu);

    }

    @Override
    public List<Menu> getMenuByIdStore(int idStore) {
        User u = (User) this.userRepository.getUserById(idStore);
        return this.menuRepository.getMenuByIdStore(u);
    }

}
