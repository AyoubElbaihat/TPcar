package com.example.tpcar.Dao;

import com.example.tpcar.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao{
    @Override
    public boolean create(User entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOk = false;
        try{
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO users(username, password) VALUES(?,?)");
            prepareStatement.setString(1, entity.getUsername());
            prepareStatement.setString(2, entity.getPassword());

            int rowsAffected = prepareStatement.executeUpdate();

            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertOk;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, username, password FROM users");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                userList.add(new User(id, username, password));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }


    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    public User findByUsername(String usernameFind) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, username, password FROM users WHERE username=?");
            statement.setString(1, usernameFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                userFound = new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }

}
