package com.lft.reflect.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leapfrog on 7/11/16.
 */
@WebServlet("")
public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello all");
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/hello.jsp");
        /*Passenger p = new Passenger();
        p.setFirstName("");
        p.setLastName("");
        req.setAttribute("passenger", p);*/
        view.forward(req, resp);
    }
}
