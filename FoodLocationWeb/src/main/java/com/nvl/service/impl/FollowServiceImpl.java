/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.nvl.pojo.Follow;
import com.nvl.pojo.User;
import com.nvl.repository.FollowRepository;
import com.nvl.repository.UserRepository;
import com.nvl.service.FollowService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyuut
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addFollow(User customer, int idStore) {
        User u = this.userRepository.getUserById(idStore);
        if (customer != null && u != null) {
            Follow c = new Follow();
            c.setIdStore(u);
            c.setIdUser(customer);
            return this.followRepository.addFollow(c);

        }
        return false;
    }

    @Override
    public List<Follow> getFollowByIdUser(User user) {
        return this.followRepository.getFollowByIdUser(user);
    }

    @Override
    public List<Follow> getFollowByIdStore(User user) {
        return this.followRepository.getFollowByIdStore(user);

    }

    @Override
    public boolean checkFollow(User customer, int idStore) {
        User u = this.userRepository.getUserById(idStore);
        return this.followRepository.checkFollow(customer, u);
    }

    @Override
    public boolean deleteFollow(int idFollow) {
        Follow f = (Follow) this.followRepository.getFollowById(idFollow);
        return this.followRepository.deleteFollow(f);
    }

}
