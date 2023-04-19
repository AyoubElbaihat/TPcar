package com.example.tpcar.Dao;

import com.example.tpcar.model.Category;
import com.example.tpcar.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao{
    @Override
    public boolean create(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOK = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categorys(catname) VALUES (?)");

            preparedStatement.setString(1, entity.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            insertOK = rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return insertOK;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,catname FROM categorys");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String catname = resultSet.getString("catname");
                categoryList.add(new Category(id, catname));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categorys SET catname=? WHERE id=?");
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categorys WHERE id=?");
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Category findByCategory(String categoryname) {
        Category catFound = null;
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, catname FROM categorys WHERE catname=?");
            statement.setString(1, categoryname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String catname = resultSet.getString("catname");
                catFound = new Category(id, catname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catFound;
    }
}
