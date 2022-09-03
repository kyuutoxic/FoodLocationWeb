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

    boolean activeUser(int id);

    List<User> getUser(String username);

    User getUserById(int idUser);

    List<User> getUserStoreNotActive();

    List<User> getUserStore();

    List<User> checkPhone(String phone);
    
    List<User> checkEmail(String email);
    
    boolean updateUser(User user);
    
    List<Object> countRatings(int idStore);
    
    List<Object> countComments(int idStore);

}
