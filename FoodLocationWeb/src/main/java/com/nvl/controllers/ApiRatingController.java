/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import com.nvl.service.RatingService;
import com.nvl.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyuut
 */
@RestController
@RequestMapping("/api")
public class ApiRatingController {

    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private UserService userDetailsService;

    @PostMapping(path = "/add-rating", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Object>> addRating(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null) {
            Map<String, String> rate = new HashMap<>();
            rate.put("rateQuality", params.get("rateQuality"));
            rate.put("rateService", params.get("rateService"));
            rate.put("rateSpace", params.get("rateSpace"));
            rate.put("ratePrice", params.get("ratePrice"));
            rate.put("rateLocation", params.get("rateLocation"));
            int storeId = Integer.parseInt(params.get("storeId"));
            System.out.println(this.ratingService.getRatingByUserAndUserStoreId(u, storeId));

            if (this.ratingService.getRatingByUserAndUserStoreId(u, storeId) == null) {
                this.ratingService.addRating(rate, u, storeId);
                return new ResponseEntity<>(this.userDetailsService.countRatings(storeId), HttpStatus.OK);
            } else {
                this.ratingService.updateRating(u, storeId, rate);
                return new ResponseEntity<>(this.userDetailsService.countRatings(storeId), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/check-rating/{idStore}")
    public ResponseEntity<Map<String, String>> checkRating(@PathVariable(value = "idStore") int idStore, HttpSession session) {
        Map<String, String> res = new HashMap<>();
        res.put("errMsg", "Something went wrong, maybe not login yet!");
        User u = (User) session.getAttribute("currentUser");
        if(u != null){
            if (this.ratingService.checkOrderForRating(u.getIdUser(), idStore) == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
