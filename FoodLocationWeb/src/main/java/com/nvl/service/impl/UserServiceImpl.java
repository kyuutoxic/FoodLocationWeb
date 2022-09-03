/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nvl.pojo.User;
import com.nvl.repository.UserRepository;
import com.nvl.service.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghuuthanh
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {
        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(User.USER);
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            user.setPhone(user.getPhone());
            user.setAddress("");

            user.setCreatedDate(new Date());
            user.setUpdateDate(new Date());
            user.setActive(Boolean.TRUE);
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));

            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getUser(String username) {
        return this.userRepository.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUser(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!!!");
        }

        User user = users.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public boolean addUserStore(User user) {
        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(User.STORE);
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            user.setPhone(user.getPhone());
            user.setAddress(user.getAddress());

            user.setCreatedDate(new Date());
            user.setUpdateDate(new Date());
            user.setActive(Boolean.FALSE);
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));

            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getUserStoreNotActive() {
        return this.userRepository.getUserStoreNotActive();
    }

    @Override
    public User getUserById(int userId) {
        return this.userRepository.getUserById(userId);
    }

    @Override
    public boolean activeUserStore(int id) {
        if (id != -1) {
            return this.userRepository.activeUser(id);
        }

        return false;
    }

    @Override
    public List<User> getUserStore() {
        return this.userRepository.getUserStore();
    }

    @Override
    public boolean updateUser(int idUser, User user) {
        User u = this.userRepository.getUserById(idUser);
        if (user != null && u != null) {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setPhone(user.getPhone());
            u.setAddress(user.getAddress());
            u.setNameStore(user.getNameStore());
            u.setShipPrice(user.getShipPrice());
            u.setUserIframe(user.getUserIframe());

            u.setUpdateDate(new Date());
            if (user.getFile().getSize() > 0) {
                Map r;
                try {
                    r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    u.setAvatar((String) r.get("secure_url"));
                } catch (IOException ex) {
                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return this.userRepository.updateUser(u);
    }

    @Override
    public List<User> checkPhone(String phone) {
        return this.userRepository.checkPhone(phone);
    }

    @Override
    public List<User> checkEmail(String email) {
        return this.userRepository.checkEmail(email);
    }

    @Override
    public List<Object> countRatings(int idStore) {
        return this.userRepository.countRatings(idStore);
    }

    @Override
    public List<Object> countComments(int idStore) {
        return this.userRepository.countComments(idStore);
    }
}
