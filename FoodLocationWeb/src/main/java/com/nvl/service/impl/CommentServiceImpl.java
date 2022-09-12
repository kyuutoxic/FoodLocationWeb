/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.nvl.pojo.Comment;
import com.nvl.pojo.User;
import com.nvl.repository.CommentRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyuut
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int storeId, User creator) {
        User u = this.userRepository.getUserById(storeId);

        Comment c = new Comment();
        c.setContent(content);
        c.setIdStore(u);
        c.setIdUser(creator);
        c.setCreatedDate(new Date());
        c.setUpdateDate(new Date());

        return this.commentRepository.addComment(c);
    }

    @Override
    public List<Comment> getCommentByStoreId(int storeId) {
        return this.commentRepository.getCommentByStoreId(storeId);

    }
}
