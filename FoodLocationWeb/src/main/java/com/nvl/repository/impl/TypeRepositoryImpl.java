/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Type;
import com.nvl.repository.TypeRepository;
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
public class TypeRepositoryImpl implements TypeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Type> getType() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Type");
        return q.getResultList();
    }

    @Override
    public Type getTypeById(int typeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Type.class, typeId);
    }
}
