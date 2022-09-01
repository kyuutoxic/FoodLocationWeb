/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Rating;
import com.nvl.pojo.User;

/**
 *
 * @author kyuut
 */
public interface RatingService {

    boolean addRating(int rate, User user, int idStore);

    boolean updateRating(User user, int idStore, int rate);
    
    Rating getRatingByUserAndUserStoreId(User user, int idStore);

}
