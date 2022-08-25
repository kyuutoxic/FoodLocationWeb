/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository.impl;

import com.nvl.pojo.Menu;
import com.nvl.pojo.Type;
import com.nvl.pojo.User;
import com.nvl.repository.MenuRepository;
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

}
