/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Follow;
import com.nvl.pojo.User;
import com.nvl.service.FollowService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiFollowController {

    @Autowired
    private FollowService followService;

    @PostMapping(path = "/follow", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Follow> addFollow(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        try {
            int storeId = Integer.parseInt(params.get("storeId"));
            System.out.println(storeId);
            if (this.followService.checkFollow(u, storeId) == false) {
                this.followService.addFollow(u, storeId);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/check-follow", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Follow>> checkFollow(HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        return new ResponseEntity<>(this.followService.getFollowByIdUser(u), HttpStatus.OK);
    }
}
