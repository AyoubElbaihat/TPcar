package com.example.tpcar.model;

public class Car {
    private int id;
    private String carname;
    private String description;
    private String urlimg;
    private double prix;
    private int category_id;

    public Car(String carname, String description, String urlimg, double prix, int category_id) {
        this.carname = carname;
        this.description = description;
        this.urlimg = urlimg;
        this.prix = prix;
        this.category_id = category_id;
    }

    public Car(int id, String carname, String description, String urlimg, double prix, int category_id) {
        this.id = id;
        this.carname = carname;
        this.description = description;
        this.urlimg = urlimg;
        this.prix = prix;
        this.category_id = category_id;
    }

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCarname() {
        return carname;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public double getPrix() {
        return prix;
    }

    public int getCategory_id() {
        return category_id;
    }
}
