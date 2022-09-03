/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.controllers;

import com.nvl.pojo.Comment;
import com.nvl.pojo.User;
import com.nvl.service.CommentService;
import com.nvl.service.UserService;
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
public class ApiCommentController {

    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userDetailsService;
    
    @PostMapping(path = "/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try {
                String content = params.get("content");
                int storeId = Integer.parseInt(params.get("storeId"));

                Comment c = this.commentService.addComment(content, storeId, u);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/count-comments/{idStore}")
    public ResponseEntity<List<Object>> countRating(Model model, @PathVariable(value = "idStore") int idStore) {
        return new ResponseEntity<>(this.userDetailsService.countComments(idStore), HttpStatus.OK);
    }
}
