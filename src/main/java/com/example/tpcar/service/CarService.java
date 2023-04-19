package com.example.tpcar.service;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.model.Car;

import java.time.LocalDateTime;

public class CarService {
CarJdbcDao carJdbcDao = new CarJdbcDao();
    public Car createCar(String carname, String description, String urlimg, double prix,int category_id) {
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        Car c = new Car(carname, description, urlimg,prix,category_id);
        carJdbcDao.create(c);
        return c;
    }
}
