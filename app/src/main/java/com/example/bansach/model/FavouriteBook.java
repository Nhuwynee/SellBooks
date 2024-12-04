package com.example.bansach.model;

public class FavouriteBook {
    private int idUser;
    private int idBook;

    public FavouriteBook(int idUser, int idBook) {
        this.idUser = idUser;
        this.idBook = idBook;
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdBook() {
        return idBook;
    }
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        return "FavouriteBook{" +
                "idUser=" + idUser +
                ", idBook=" + idBook +
                '}';
    }
}
