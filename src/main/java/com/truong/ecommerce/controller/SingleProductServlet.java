package com.truong.ecommerce.controller;

import com.truong.ecommerce.dao.ProductDao;

import com.truong.ecommerce.dao.ProductDaoImpl;
import com.truong.ecommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "singleProductServlet", value = "/single-product")

public class SingleProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int productId = Integer.parseInt(id);
        ProductDao productDao = new ProductDaoImpl();
        try{
            Product product = productDao.getProductById(productId);
            req.getServletContext().setAttribute("product", product);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/single-product.jsp");
            dispatcher.forward(req, resp);
        }
        catch(Exception e){

        }
    }
}
