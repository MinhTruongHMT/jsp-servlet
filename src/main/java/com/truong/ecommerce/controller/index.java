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
import java.util.List;

@WebServlet(name = "indexServlet", value = "")
public class index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        UserDao userDao = new UserDaoImpl();
       try{
           List<User> users = userDao.getAllUsers();
           request.getServletContext().setAttribute("userList", users);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
           dispatcher.forward(request, response);
       }
       catch(Exception e){

       }

    }
}
