/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.Rating;

/**
 *
 * @author kyuut
 */
public interface RatingRepository {

    boolean addRating(Rating rating);

    boolean updateRating(Rating rating);

    Rating getRatingByUserAndUserStoreId(int idUser, int idStore);

    boolean checkOrderForRating(int idUser, int idStore);

}
