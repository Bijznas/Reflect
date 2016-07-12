package com.lft.reflect.dao;

import com.lft.reflect.model.Student;
import com.lft.reflect.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by leapfrog on 7/11/16.
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Student");
        return  q.list();
    }

    @Override
    public void add(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public void sad(){
        /*session.beginTransaction();

        Stock stock = new Stock();
        stock.setStockCode("SDS");
        stock.setStockId(1);
        stock.setStockName("What");
        session.save(stock);


        session.getTransaction().commit();*/
    }
}
