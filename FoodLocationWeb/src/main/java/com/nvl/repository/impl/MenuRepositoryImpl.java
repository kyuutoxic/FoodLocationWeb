/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Follow;
import com.nvl.pojo.Menu;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.OrderDetail;
import com.nvl.pojo.Type;
import com.nvl.pojo.User;
import com.nvl.repository.MenuRepository;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kyuut
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

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

    @Override
    public List<Menu> getMenus(String kw, int page, String sort, String type) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menu> q = b.createQuery(Menu.class);
        Root rM = q.from(Menu.class);
        Root rS = q.from(User.class);
        Root rT = q.from(Type.class);
        q.select(rM);
        
        List<Predicate> predicates = new ArrayList<>();

        if (kw != null) {
            Predicate p = b.or(b.like(rM.get("menuName").as(String.class), String.format("%%%s%%", kw))
                    ,b.like(rM.get("price").as(String.class), String.format("%%%s%%", kw))
                    ,b.and(b.like(rS.get("nameStore").as(String.class), String.format("%%%s%%", kw))
                           ,b.equal(rS.get("idUser"),rM.get("idStore")))
                );
            predicates.add(p);
        }
        
        if (type != null) {
            switch ( type ) {
                case  "All day":
                    Predicate pd = b.and(b.equal(rT.get("name"), type)
                          ,b.equal(rT.get("name"), "All day")
                          ,b.equal(rM.get("idType"), rT.get("id"))
                        );
                    predicates.add(pd);
                    break;
                case  "Night":
                    Predicate pr = b.and(b.equal(rT.get("name"), type)
                          ,b.equal(rM.get("idType"), rT.get("id"))
                        );
                    predicates.add(pr);
                    break;
                default:
                    Predicate pre = b.or(b.and(b.equal(rT.get("name"), type),b.equal(rM.get("idType"), rT.get("id")))
                                        ,b.and(b.equal(rT.get("name"), "All day"),b.equal(rM.get("idType"), rT.get("id")))
                                        );
                    predicates.add(pre);
            }
        }
        
        q.where(predicates.toArray(Predicate[]::new));
        
        q.groupBy(rM.get("idMenu"));
        
        if (sort != null) {
            if (sort.equals("asc")) {
                q.orderBy(b.asc(rM.get("price")));
            }

            if (sort.equals("desc")){
                q.orderBy(b.desc(rM.get("price")));
            }
        }
//        q.multiselect(rM.get("idMenu"),rM.get("menuName"),rM.get("price"),rM.get("menuStatus"),rM.get("image"),rM.get("idStore"),rM.get("menuStatus"));

        Query query = session.createQuery(q);
        
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countMenu(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Menu");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Menu getMenuById(int idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Menu.class, idMenu);
    }

    @Override
    public List<Menu> getMenuByIdStore(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery(Menu.class);
        Root root = query.from(Menu.class);
        query = query.select(root);

        Predicate p = builder.equal(root.get("idStore"), idStore);
        query = query.where(p);

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object> frequency(int quarter, int month, int idStore, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Menu.class);
        Root rD = q.from(OrderDetail.class);
        Root rO = q.from(MenuOrder.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        Predicate rootPredicates = b.and(b.equal(rD.get("idMenu"), rM.get("idMenu")),
                                         b.equal(rD.get("idOrder"), rO.get("idOrder")));
        
        predicates.add(rootPredicates);
        
        if (quarter > 0 && quarter <= 4) {
            Predicate p = b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), quarter);
            predicates.add(p);
        }else if (month > 0 && month <= 12) {
            Predicate p = b.equal(b.function("MONTH", Integer.class, rO.get("createdDate")), month);
            predicates.add(p);
        }
                     
        if (year > 1900 && year <= Year.now().getValue()) {
            Predicate p = b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year);
            predicates.add(p);
        }
        
        if (idStore > 0) {
            Predicate p = b.equal(rM.get("idStore"), idStore);
            predicates.add(p);
        }

        q.where(predicates.toArray(Predicate[]::new));
        
        q.multiselect(b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));
        
        Query revenueQuery = session.createQuery(q);
        
        Object revenue = revenueQuery.getSingleResult();
        
        String revenueText;
        
        int revenueValue;
        
        if(revenue != null){
            revenueText = revenue.toString();
            revenueValue = Integer.parseInt(revenueText.substring(0, revenueText.indexOf('.')));
        }else{
            revenueValue = 1;
        }
        
        System.out.println(revenue);

        q.multiselect(rM.get("idMenu"), 
                      rM.get("menuName"), 
                      b.count(rD.get("idOrderDetail")), 
                      b.sum(b.prod(rD.get("unitPrice"), 
                      rD.get("quantity"))), 
                      b.quot(b.prod(b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))),100), revenueValue));
        q.groupBy(rD.get("idMenu"));
        q.orderBy(b.asc(rD.get("idMenu")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object> total(int quarter, int month, int idStore, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Menu.class);
        Root rD = q.from(OrderDetail.class);
        Root rO = q.from(MenuOrder.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        Predicate rootPredicates = b.and(b.equal(rD.get("idMenu"), rM.get("idMenu")),
                                         b.equal(rD.get("idOrder"), rO.get("idOrder")),
                                         b.equal(rM.get("idStore"), idStore));
        
        predicates.add(rootPredicates);
        
        if (quarter > 0 && quarter <= 4) {
            Predicate p = b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), quarter);
            predicates.add(p);
        }else if (month > 0 && month <= 12) {
            Predicate p = b.equal(b.function("MONTH", Integer.class, rO.get("createdDate")), month);
            predicates.add(p);
        }
        System.out.println(year);
        if (year > 1900 && year <= Year.now().getValue()) {
            Predicate p = b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year);
            predicates.add(p);
        }

        q.where(predicates.toArray(Predicate[]::new));
        
        q.multiselect(b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));
        
        Query revenueQuery = session.createQuery(q);
        
        Object revenue = revenueQuery.getSingleResult();
        
        String revenueText;
        
        int revenueValue;
        
        if(revenue != null){
            revenueText = revenue.toString();
            revenueValue = Integer.parseInt(revenueText.substring(0, revenueText.indexOf('.')));
        }else{
            revenueValue = 1;
        }

        q.multiselect(rM.get("idMenu"), 
                      rM.get("menuName"), 
                      b.count(rD.get("idOrderDetail")), 
                      b.sum(b.prod(rD.get("unitPrice"), 
                      rD.get("quantity"))), 
                      b.quot(b.prod(b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))),100), revenueValue));
        q.groupBy(rD.get("idMenu"));
        q.orderBy(b.asc(rD.get("idMenu")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object> statsStore(int idStore) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Menu.class);
        Root rD = q.from(OrderDetail.class);
        Root rO = q.from(MenuOrder.class);

        q.where(b.equal(rD.get("idMenu"), rM.get("idMenu")),
                        b.equal(rD.get("idOrder"), rO.get("idOrder")),
                        b.equal(rM.get("idStore"), idStore));
        
//        follow of store
        CriteriaQuery<Object[]> countFollow = b.createQuery(Object[].class);
        Root rF = countFollow.from(Follow.class);
        countFollow.where(b.equal(rF.get("idStore"), idStore));
        countFollow.multiselect(b.count(rF.get("idUser")));
        Query queryFollow = session.createQuery(countFollow);
        Object follow = queryFollow.getSingleResult();
        String followText;
        double followValue;
        if(follow != null){
            followText = follow.toString();
            followValue = Integer.parseInt(followText);
        }else{
            followValue = 0;
        }
        
//        user purchase history
        CriteriaQuery<Object[]> countUser = b.createQuery(Object[].class);
        Root menuOrder = countUser.from(MenuOrder.class);
        countUser.multiselect(b.count(menuOrder.get("idUser")));
        countUser.groupBy(menuOrder.get("idUser"));
        Query queryUser = session.createQuery(countUser);
        List<Object> user = queryUser.getResultList();
        double userValue;
        if(user != null){
            userValue = user.size();
        }else{
            userValue = 0;
        }
//        use 
//        sql = "select id from hii where id=:id"
//        Query query = session.createQuery(sql)
//        query.setParameter("id",id)
        q.multiselect(b.sum(rD.get("quantity")), 
                      b.sum(b.prod(rD.get("unitPrice"),rD.get("quantity"))),
                      b.quot(b.prod(b.sum(b.diff(rD.get("quantity"), rD.get("quantity")),followValue), 100), userValue));
        q.groupBy(rM.get("idStore"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
