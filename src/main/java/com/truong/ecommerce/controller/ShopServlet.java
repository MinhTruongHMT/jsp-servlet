package com.truong.ecommerce.controller;

import com.truong.ecommerce.dao.ProductDao;
import com.truong.ecommerce.dao.ProductDaoImpl;
import com.truong.ecommerce.dao.UserDao;
import com.truong.ecommerce.dao.UserDaoImpl;
import com.truong.ecommerce.entity.Product;
import com.truong.ecommerce.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "shopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao productDao = new ProductDaoImpl();
        try{
            List<Product> products = productDao.getAllProduct();
            request.getServletContext().setAttribute("productList", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception e){

        }

    }
}
