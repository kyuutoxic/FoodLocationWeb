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
    private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Menu> getMenu() {
        return this.menuRepository.getMenu();
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

}
