package com.example.bansach.model;

public class Cart1 {
    private int idUser;
    private int idBook;
    private int number;

    public Cart1(int idUser, int idBook, int number) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.number = number;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getNumber() {
        return number;
    }

}
