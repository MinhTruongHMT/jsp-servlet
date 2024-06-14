package com.truong.ecommerce.dao;

import com.truong.ecommerce.context.DatabaseConnection;
import com.truong.ecommerce.entity.Product;
import com.truong.ecommerce.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements  ProductDao {
    @Override
    public List<Product> getAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();

        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");

                products.add(new Product(productId,name,price,quantity,image,description));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return products;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        Product product = null;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE id = " + id);

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");

                product = new Product(productId,name,price,quantity,image,description);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return product;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product rpoduct) {

    }

    @Override
    public void deleteProduct(int id) {

    }

}
