/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Menu;
import com.nvl.pojo.Type;
import com.nvl.pojo.User;
import com.nvl.repository.MenuRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kyuut
 */
@Repository
@Transactional
public class MenuRepositoryImpl implements MenuRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Menu> getMenu() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Menu");
        return q.getResultList();
    }

    @Override
    public boolean addMenu(Menu menu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(menu);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
