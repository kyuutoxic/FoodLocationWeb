/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Cart;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.User;
import com.nvl.repository.MenuRepository;
import com.nvl.repository.OrderRepository;
import java.util.Map;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author duonghuuthanh
 */
@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MenuOrder addReceipt(Map<Integer, Cart> cart, User user, float total, String type) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            MenuOrder order = new MenuOrder();
            order.setIdUser(user);
            order.setCreatedDate(new Date());
            order.setTotal(total);
            order.setTypePayment(type);

            session.save(order);

            for (Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setIdOrder(order);
                d.setIdMenu(this.menuRepository.getMenuById(c.getMenuId()));
                d.setUnitPrice(c.getPrice());
                d.setQuantity(c.getQuantity());
                d.setStatusOrder((short)2);

                session.save(d);
            }

            return order;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    @Override
    public List<MenuOrder> getOrderByIdStore(int storeId) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Menu> q = b.createQuery(Menu.class);
//        Root root = q.from(Menu.class);
//        q.select(root);
//
//        List<Predicate> predicates = new ArrayList<>();
//        Predicate p = b.like(root.get("").as(String.class), String.format("%%%s%%", kw));
//        predicates.add(p);
//
//        q.where(predicates.toArray(Predicate[]::new));
//
//        Query query = session.createQuery(q);
//
//        return query.getResultList();
        return null;
    }

    @Override
    public List<MenuOrder> getOrderByIdOrderDetail(int idOrderDetail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuOrder> query = builder.createQuery(MenuOrder.class);
        Root rO = query.from(MenuOrder.class);
        Root rD = query.from(OrderDetail.class);
        query = query.select(rO);

        query = query.where(builder.equal(rD.get("idOrderDetail"), idOrderDetail),
                            builder.equal(rO.get("idOrder"), rD.get("idOrder")));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<MenuOrder> getOrder() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuOrder> query = builder.createQuery(MenuOrder.class);
        Root rO = query.from(MenuOrder.class);
        query = query.select(rO);

        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
