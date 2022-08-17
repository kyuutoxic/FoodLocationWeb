/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserRepository {

    boolean addUser(User user);

    List<User> getUser(String username);

    User getUserById(int idUser);

    List<User> getUserStore();

}
