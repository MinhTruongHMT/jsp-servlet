package com.truong.ecommerce.controller;

import com.truong.ecommerce.dao.UserDao;
import com.truong.ecommerce.dao.UserDaoImpl;
import com.truong.ecommerce.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productDetailServlet", value = "/product_detail")
public class productDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int productId = Integer.parseInt(id);
        UserDao userDao = new UserDaoImpl();
        try{
            User users = userDao.getUserById(productId);
            req.getServletContext().setAttribute("user", users);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/product_detail.jsp");
            dispatcher.forward(req, resp);
        }
        catch(Exception e){

        }
    }
}
