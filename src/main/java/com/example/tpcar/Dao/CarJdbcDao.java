package com.example.tpcar.Dao;

import com.example.tpcar.model.Car;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarJdbcDao implements CarDao{

    @Override
    public boolean create(Car entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOK = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars(id, carname, description,urlimg,prix,category_id) VALUES (?,?,?,?,?,?)");

            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getCarname());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setString(4, entity.getUrlimg());
            preparedStatement.setDouble(5, entity.getPrix());
            preparedStatement.setInt(6, entity.getCategory_id());

            int rowsAffected = preparedStatement.executeUpdate();
            insertOK = rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return insertOK;
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,carname,description,urlimg,prix,category_id FROM cars");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String carname = resultSet.getString("carname");
                String description = resultSet.getString("description");
                String urlimg = resultSet.getString("urlimg");
                double prix = resultSet.getDouble("prix");
                int category_id = resultSet.getInt("category_id");
                carList.add(new Car(id, carname, description,urlimg,prix,category_id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public Car findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Car entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cars SET carname=?, description=?, urlimg=?, prix=?, category_id=? WHERE id=?");
            preparedStatement.setString(1, entity.getCarname());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setString(3, entity.getUrlimg());
            preparedStatement.setDouble(4, entity.getPrix());
            preparedStatement.setInt(5, entity.getCategory_id());
            preparedStatement.setLong(6, entity.getId());
            preparedStatement.executeUpdate();
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Car entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE id=?");
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
