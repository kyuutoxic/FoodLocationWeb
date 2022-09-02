/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service;

import com.nvl.pojo.Follow;
import com.nvl.pojo.User;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface FollowService {

    boolean addFollow(User customer, int idStore);

    boolean checkFollow(User customer, int idStore);

    List<Follow> getFollowByIdUser(User user);

    List<Follow> getFollowByIdStore(User user);

    boolean deleteFollow(int idFollow);

}
