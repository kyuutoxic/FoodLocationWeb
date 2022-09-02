/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Menu;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
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

    @Override
    public boolean checkOrderForRating(int idUser, int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Rating> q = b.createQuery(Rating.class);
        Root rM = q.from(Menu.class);
        Root rD = q.from(OrderDetail.class);
        Root rO = q.from(MenuOrder.class);
        Root rU = q.from(User.class);

        q.where(b.equal(rD.get("idOrder"), rO.get("idOrder")),
                b.equal(rD.get("idMenu"), rM.get("idMenu")),
                b.equal(rO.get("idUser"), idUser),
                b.equal(rM.get("idStore"), idStore));

        q.multiselect(rO.get("idUser"));

        q.groupBy(rO.get("idUser"));

        Object user = session.createQuery(q).getSingleResult();

        if(user != null){
            return true;
        }else{
            return false;
        }
    }

}
