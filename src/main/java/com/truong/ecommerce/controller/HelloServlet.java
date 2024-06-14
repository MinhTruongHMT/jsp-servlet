package com.truong.ecommerce.controller;

import com.truong.ecommerce.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "truong"));
        users.add(new User(2, "nam"));
        users.add(new User(3, "phieu"));
        users.add(new User(4, "phuc"));
        users.add(new User(5, "hai"));
        request.getServletContext().setAttribute("userList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}