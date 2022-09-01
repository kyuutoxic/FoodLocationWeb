/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import com.nvl.repository.RatingRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.RatingService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyuut
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addRating(int rate, User user, int idStore) {
        User store = (User) this.userRepository.getUserById(idStore);
        Rating rating = new Rating();
        if (user != null && store != null) {
            rating.setRate(rate);
            rating.setIdUser(user);
            rating.setIdStore(store);
            rating.setCreatedDate(new Date());
        }
        return this.ratingRepository.addRating(rating);
    }

    @Override
    public boolean updateRating(User user, int idStore, int rate) {
        Rating rating = (Rating) this.ratingRepository.getRatingByUserAndUserStoreId(user.getIdUser(), idStore);
        if (rating != null) {
            rating.setRate(rate);
        }
        return this.ratingRepository.updateRating(rating);

    }

    @Override
    public Rating getRatingByUserAndUserStoreId(User user, int idStore) {
        return this.ratingRepository.getRatingByUserAndUserStoreId(user.getIdUser(), idStore);
    }

}
