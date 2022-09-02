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
import java.util.Map;
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
    public boolean addRating(Map<String, String> rate, User user, int idStore) {
        User store = (User) this.userRepository.getUserById(idStore);
        Rating rating = new Rating();
        if (user != null && store != null) {
            rating.setRateQuality(Integer.parseInt(rate.get("rateQuality")));
            rating.setRateService(Integer.parseInt(rate.get("rateService")));
            rating.setRateSpace(Integer.parseInt(rate.get("rateSpace")));
            rating.setRatePrice(Integer.parseInt(rate.get("ratePrice")));
            rating.setRateLocation(Integer.parseInt(rate.get("rateLocation")));
            rating.setIdUser(user);
            rating.setIdStore(store);
            rating.setCreatedDate(new Date());
            rating.setUpdateDate(new Date());
        }
        return this.ratingRepository.addRating(rating);
    }

    @Override
    public boolean updateRating(User user, int idStore, Map<String, String> rate) {
        Rating rating = (Rating) this.ratingRepository.getRatingByUserAndUserStoreId(user.getIdUser(), idStore);
        if (rating != null) {
            rating.setRateQuality(Integer.parseInt(rate.get("rateQuality")));
            rating.setRateService(Integer.parseInt(rate.get("rateService")));
            rating.setRateSpace(Integer.parseInt(rate.get("rateSpace")));
            rating.setRatePrice(Integer.parseInt(rate.get("ratePrice")));
            rating.setRateLocation(Integer.parseInt(rate.get("rateLocation")));
            rating.setUpdateDate(new Date());
        }
        return this.ratingRepository.updateRating(rating);

    }

    @Override
    public Rating getRatingByUserAndUserStoreId(User user, int idStore) {
        return this.ratingRepository.getRatingByUserAndUserStoreId(user.getIdUser(), idStore);
    }

    @Override
    public boolean checkOrderForRating(int idUser, int idStore) {
        return this.ratingRepository.checkOrderForRating(idUser, idStore);
    }


}
