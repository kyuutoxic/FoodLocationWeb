/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import com.nvl.service.RatingService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyuut
 */
@RestController
public class ApiRatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/api/add-rating", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Rating> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null) {
            int rate = Integer.parseInt(params.get("rate"));
            int storeId = Integer.parseInt(params.get("storeId"));
            System.out.println(this.ratingService.getRatingByUserAndUserStoreId(u, storeId));

            if (this.ratingService.getRatingByUserAndUserStoreId(u, storeId) == null) {
                this.ratingService.addRating(rate, u, storeId);
            }else{
                this.ratingService.updateRating(u, storeId, rate);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
