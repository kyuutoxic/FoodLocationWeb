/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nvl.pojo.Comment;
import com.nvl.pojo.Rating;
import com.nvl.pojo.User;
import com.nvl.repository.UserRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUser(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> getUserStoreNotActive() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("userRole").as(String.class), "ROLE_STORE"));
        predicates.add(builder.equal(root.get("active"), Boolean.FALSE));
        predicates.add(builder.equal(root.get("isDelete"), Boolean.FALSE));

        query = query.where(predicates.toArray(new Predicate[] {}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User getUserById(int idUser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(User.class, idUser);
    }

    @Override
    public boolean activeUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User u = session.get(User.class, id);
            u.setActive(Boolean.TRUE);
            session.save(u);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUserStore() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("userRole").as(String.class), "ROLE_STORE"));
        predicates.add(builder.equal(root.get("active"), Boolean.TRUE));
        predicates.add(builder.equal(root.get("isDelete"), Boolean.FALSE));

        query = query.where(predicates.toArray(new Predicate[] {}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> checkPhone(String phone) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("phone").as(String.class), phone));

        query = query.where(predicates.toArray(new Predicate[] {}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> checkEmail(String email) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("email").as(String.class), email));

        query = query.where(predicates.toArray(new Predicate[] {}));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean updateUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        System.out.println(user);
        try {
            session.update(user);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Object> countRatings(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);
        Root rR = query.from(Rating.class);

        query = query.where(b.equal(rR.get("idStore"), idStore));
        
        query.multiselect(b.count(rR.get("idRating")),
                          b.avg(rR.get("rateQuality")),
                          b.avg(rR.get("rateService")),
                          b.avg(rR.get("rateSpace")),
                          b.avg(rR.get("ratePrice")),
                          b.avg(rR.get("rateLocation")));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object> countComments(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);
        Root rC = query.from(Comment.class);

        query = query.where(b.equal(rC.get("idStore"), idStore));
        
        query.multiselect(b.count(rC.get("idComment")));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> manageStore() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);

        query.where(builder.equal(root.get("userRole").as(String.class), "ROLE_STORE"));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> manageUser() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);

        query.where(builder.equal(root.get("userRole").as(String.class), "ROLE_USER"));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean changeIsDelete(int idUser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User user = session.get(User.class, idUser);
            user.setIsDelete(!user.getIsDelete());
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean changeActive(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User user = session.get(User.class, idStore);
            user.setActive(!user.getActive());
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

}
