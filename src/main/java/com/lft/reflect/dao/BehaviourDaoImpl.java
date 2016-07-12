package com.lft.reflect.dao;

import com.lft.reflect.model.Behaviour;
import com.lft.reflect.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public class BehaviourDaoImpl implements BehaviourDao{
    @Override
    public List<Behaviour> getAllBehaviours() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Behaviour");
        return  q.list();
    }

    @Override
    public void add(Behaviour behaviour) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(behaviour);
        session.getTransaction().commit();
    }
}
