package com.lft.reflect.controller;

import com.lft.reflect.dao.StudentDao;
import com.lft.reflect.dao.StudentDaoImpl;
import com.lft.reflect.model.Student;
import com.lft.reflect.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.service.spi.InjectService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leapfrog on 7/11/16.
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {


    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello all");
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/hello.jsp");


        System.out.println("Maven + Hibernate + MySQL1");
        List<Student> s = studentDao.getAllStudents();

        System.out.println(s);



        System.out.println("Maven + Hibernate + MySQL2");



        view.forward(req, resp);
    }
}
