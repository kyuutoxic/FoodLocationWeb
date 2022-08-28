/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Follow;
import com.nvl.pojo.User;
import com.nvl.repository.FollowRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class FollowRepositoryImpl implements FollowRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addFollow(Follow f) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(f);

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Follow> getFollowByIdUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Follow> query = builder.createQuery(Follow.class);
        Root root = query.from(Follow.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("idUser"), user));

        query = query.where(predicates.toArray(new Predicate[]{}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Follow> getFollowByIdStore(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Follow> query = builder.createQuery(Follow.class);
        Root root = query.from(Follow.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("idStore"), user));

        query = query.where(predicates.toArray(new Predicate[]{}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean checkFollow(User customer, User store) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Follow> query = builder.createQuery(Follow.class);
        Root root = query.from(Follow.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("idUser"), customer));
        predicates.add(builder.equal(root.get("idStore"), store));

        query = query.where(predicates.toArray(new Predicate[]{}));

        Query q = session.createQuery(query);
        if (!q.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
