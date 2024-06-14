package com.truong.ecommerce.controller;

import com.truong.ecommerce.dao.ProductDao;
import com.truong.ecommerce.dao.ProductDaoImpl;
import com.truong.ecommerce.dao.UserDao;
import com.truong.ecommerce.entity.Item;
import com.truong.ecommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        if (action == null) {
            doGet_DisplayCart(request, response);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                doGet_Buy(request, response);
            } else if (action.equalsIgnoreCase("remove")) {
                doGet_Remove(request, response);
            }
        }

    }

    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> carts = (List<Item>) session.getAttribute("cart");
        if (carts == null) {
            carts = new ArrayList<>();
        }
        request.getServletContext().setAttribute("carts", carts);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }


    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExisting(request.getParameter("id"), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }


    protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDao productDao = new ProductDaoImpl();
           try{
               Product product = productDao.getProductById(id);
               cart.add(new Item(product.getId(),1,product,1,product.getPrice()));
           }
           catch (Exception e){}
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(request.getParameter("id"), cart);
            if (index == -1) {
                int id = Integer.parseInt(request.getParameter("id"));
                try{
                    ProductDao productDao = new ProductDaoImpl();
                    Product product = productDao.getProductById(id);
                    cart.add(new Item(product.getId(),1,product,1,1));
                }
                catch (Exception e){}
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setPrice(quantity * cart.get(index).getProduct().getPrice());
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("cart");
    }
    private int isExisting(String id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
