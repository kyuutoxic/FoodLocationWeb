/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import java.util.Map;

/**
 *
 * @author kyuut
 */
public interface RatingService {

    boolean addRating(Map<String, String> rate, User user, int idStore);

    boolean updateRating(User user, int idStore, Map<String, String> rate);
    
    Rating getRatingByUserAndUserStoreId(User user, int idStore);

    boolean checkOrderForRating(int idUser, int idStore);
}
