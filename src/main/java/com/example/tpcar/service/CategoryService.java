package com.example.tpcar.service;

import com.example.tpcar.Dao.CarJdbcDao;
import com.example.tpcar.Dao.CategoryJdbcDao;
import com.example.tpcar.model.Car;
import com.example.tpcar.model.Category;

public class CategoryService {
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public Category createCategory(String catname) {

        Category c = new Category(catname);
        categoryJdbcDao.create(c);
        return c;
    }
}
