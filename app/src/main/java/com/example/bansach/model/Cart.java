package com.example.bansach.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cart {
    private int idBook;
    private String title;
    private String author;
    private String category;
    private String imgResource;
    private float price;
    private int inStock;
    private String description;
    private String review;
    private String detailAuthor;
    private int pointOfBook;
    private String URLaudioBook;
    private String sampleRead;
    private String isActive;
    private int idUser;
    private int number;
    private int point;
    private String name;
    private String phone;
    private String address;
    private String avatarImage;

    public Cart(int id, String title, String author, String category, String imgURL, float price, int inStock, String description, String review,String detailAuthor, int pointOfBook, String URLaudioBook, String sampleRead, String isActive, int idUser, int number, int point) {
        this.idBook = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.imgResource = imgURL;
        this.price = price;
        this.inStock = inStock;
        this.description = description;
        this.review = review;
        this.detailAuthor = detailAuthor;
        this.pointOfBook = pointOfBook;
        this.URLaudioBook = URLaudioBook;
        this.sampleRead = sampleRead;
        this.isActive = isActive;
        this.idUser = idUser;
        this.number = number;
        this.point = point;
    }
public Cart(  int idUser, int idBook, int number) {
    this.idUser = idUser;
    this.idBook = idBook;
    this.number= number;
}

    @Override
    public String toString() {
        return "Book{" +
                "id='" + idBook + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", imgURL='" + imgResource + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                ", detailAuthor='" + detailAuthor + '\'' +
                ", point='" + pointOfBook + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getId() {
        return idBook;
    }

    public void setId(int id) {
        this.idBook = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void setImgResource(String imgURL) {
        this.imgResource = imgURL;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDetailAuthor() {
        return detailAuthor;
    }

    public void setDetailAuthor(String detailAuthor) {
        this.detailAuthor = detailAuthor;
    }

    public int getPoint() {
        return pointOfBook;
    }

    public void setPointOfBook(int point) {
        this.pointOfBook = point;
    }
    public String getURLaudioBook() {
        return URLaudioBook;
    }

    public void setURLaudioBook(String URLaudioBook) {
        this.URLaudioBook = URLaudioBook;
    }

    public String getSampleRead() {
        return sampleRead;
    }

    public void setSampleRead(String sampleRead) {
        this.sampleRead = sampleRead;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }


    public String isActive() {
        return this.isActive;
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPointSum() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }
}
