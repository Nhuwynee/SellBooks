package com.example.bansach.model;

public class Contact_listbook {
    private String title;
    private String author;
    private String price;
    private String status;
    private int coverImageResource;

    public Contact_listbook(String title, String author, String price, String status, int coverImageResource) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = status;
        this.coverImageResource = coverImageResource;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getCoverImageResource() {
        return coverImageResource;
    }
}
