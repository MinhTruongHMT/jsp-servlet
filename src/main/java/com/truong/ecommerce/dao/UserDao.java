package com.truong.ecommerce.dao;

import com.truong.ecommerce.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers() throws SQLException;

    User getUserById(int id) throws SQLException;

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
