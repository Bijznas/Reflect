package com.lft.reflect.dao;

import com.lft.reflect.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public class ReflectDaoImpl implements ReflectDao {
    @Override
    public List getAll(String className) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From " + className);
        return  q.list();
    }

    @Override
    public void saveOrUpdate(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
    }
}
