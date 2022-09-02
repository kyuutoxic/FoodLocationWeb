/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.Follow;
import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface FollowRepository {

    boolean addFollow(Follow f);

    boolean checkFollow(User customer, User store);

    List<Follow> getFollowByIdUser(User userId);

    List<Follow> getFollowByIdStore(User storeId);
    
    Follow getFollowById(int idFollow);

    boolean deleteFollow(Follow f);

}
