package com.truong.ecommerce.dao;

import com.truong.ecommerce.entity.Product;
import com.truong.ecommerce.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProduct() throws SQLException;

    Product getProductById(int id) throws SQLException;

    void addProduct(Product product);

    void updateProduct(Product rpoduct);

    void deleteProduct(int id);
}
