/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Rating;
import com.nvl.repository.RatingRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class RatingRepositoryImpl implements RatingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addRating(Rating rating) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(rating);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateRating(Rating rating) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.update(rating);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Rating getRatingByUserAndUserStoreId(int idUser, int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> query = builder.createQuery(Rating.class);
            Root<Rating> root = query.from(Rating.class);
            query.select(root);
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("idStore"), idStore));
            predicates.add(builder.equal(root.get("idUser"), idUser));

            query.where(predicates.toArray(new Predicate[]{}));

            return session.createQuery(query).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
