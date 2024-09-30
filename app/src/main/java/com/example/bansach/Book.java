package com.example.bansach;

public class Book {
    private String title;
    private int imageResourceId;
    private double price;

    public Book(String title, int imageResourceId, double price) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public double getPrice() {
        return price;
    }
}

