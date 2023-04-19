package com.example.tpcar.model;

public class Category {
    private int id;
    private String catname;

    public Category(String name) {
        this.catname = name;
    }

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.catname = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return catname;
    }
}
