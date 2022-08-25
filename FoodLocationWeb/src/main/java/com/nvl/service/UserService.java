/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {

    boolean addUser(User user);

    boolean addUserStore(User user);

    boolean activeUserStore(int id);

    List<User> getUser(String username);

    List<User> getUserStoreNotActive();

    List<User> getUserStore();

    User getUserById(int userId);

    boolean updateUser(int idUser, User user);

    List<User> checkPhone(String phone);

    List<User> checkEmail(String email);

}
