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
import com.nvl.utils.Utils;
import java.util.Date;
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
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart, User user) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
        
            MenuOrder order = new MenuOrder();
            order.setIdUser(user);
            order.setCreatedDate(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            order.setTotal(Long.parseLong(stats.get("amount")));

            session.save(order);

            for (Cart c: cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setIdOrder(order);
                d.setIdMenu(this.menuRepository.getMenuById(c.getMenuId()));
                d.setUnitPrice(c.getPrice());
                d.setQuantity(c.getQuantity());

                session.save(d);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

//    @Override
//    @Transactional
//    public List<Object[]> stats(Date fromDate, Date toDate) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
//        Root rootO = query.from(SaleOrder.class);
//        Root rootD = query.from(OrderDetail.class);
//        Root rootP = query.from(Product.class);
//
//        List<Predicate> pre = new ArrayList<>();
//        pre.add(builder.equal(rootD.get("orderId"), rootO.get("id")));
//        pre.add(builder.equal(rootD.get("product"), rootP.get("id")));
//    //        query.where(builder.equal(rootD.get("orderId"), rootO.get("id"))).where(builder.equal(rootD.get("product"), rootP.get("id")));
//        query.multiselect(rootP.get("id"), 
//                rootP.get("name").as(String.class), 
//                builder.sum(builder.prod(rootD.get("unitPrice"), rootD.get("num"))));
//
//        if (fromDate != null && toDate != null) {
//            Predicate p1 = builder.greaterThanOrEqualTo(rootO.get("createdDate").as(Date.class), fromDate);
//            Predicate p2 = builder.lessThanOrEqualTo(rootO.get("createdDate").as(Date.class), toDate);
//    //            query = query.where(p1, p2);
//    //            query.where(p1, p2);
//            pre.add(p1);
//            pre.add(p2);
//        }
//
//        query = query.where(pre.toArray(new Predicate[] {}));
//
//        query = query.groupBy(rootP.get("id"));
//
//        //loc
//
//        Query q = session.createQuery(query);
//
//        return q.getResultList();
//
//    }
    
}
