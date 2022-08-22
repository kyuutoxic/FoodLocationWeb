/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Comment;
import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface CommentService {

    Comment addComment(String content, int storeId, User creator);

    List<Comment> getCommentByStoreId(int storeId);

}
