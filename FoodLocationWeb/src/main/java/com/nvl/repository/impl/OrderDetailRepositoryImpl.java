/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Menu;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.User;
import com.nvl.repository.OrderDetailRepository;
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
 * @author Copeoshihi
 */
@Repository
@Transactional
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> getOrderDetailByIdStore(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rO = query.from(OrderDetail.class);
        Root rM = query.from(Menu.class);

        query.where(builder.equal(rO.get("idMenu"), rM.get("idMenu")),
                builder.equal(rM.get("idStore"), idStore),
                builder.equal(rO.get("statusOrder"), 2));
        query.multiselect(rO.get("idOrderDetail"), rO.get("idOrder"), rO.get("idMenu"), rO.get("quantity"), rO.get("unitPrice"), rO.get("statusOrder"));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean acceptOrder(int idOrderDetail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            OrderDetail o = session.get(OrderDetail.class, idOrderDetail);
            o.setStatusOrder((short) 1);
            session.save(o);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;

    }

    @Override
    public OrderDetail denyOrder(int idOrderDetail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            OrderDetail o = session.get(OrderDetail.class, idOrderDetail);
            o.setStatusOrder((short) 0);
            session.save(o);
            return o;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<OrderDetail> getOrderDetail(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rD = query.from(OrderDetail.class);
        Root rM = query.from(Menu.class);
        
        if (idStore >= 0) {
            query = query.select(rD);
            query.where(builder.equal(rD.get("idMenu"), rM.get("idMenu")),
                    builder.equal(rM.get("idStore"), idStore));
            Query q = session.createQuery(query);
            return q.getResultList();
        }

        query = query.select(rD);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<OrderDetail> getOrderDetailByIdOrder(int idOrder) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rD = query.from(OrderDetail.class);
        try{
        query = query.select(rD);
        query.where(builder.equal(rD.get("idOrder"), idOrder));
        Query q = session.createQuery(query);
        return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
