package com.example.bansach.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book1 implements Parcelable {
    private String id;
    private String title;
    private String author;
    private String category;
    private String imgResource;
    private float price;
    private int inStock;
    private String description;
    private String review;
    private String detailAuthor;
    private String point;
    private String isActive;

    public Book1(String id, String title, String author, String category, String imgURL, float price, int inStock, String description, String review,String detailAuthor, String point, String isActive) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.imgResource = imgURL;
        this.price = price;
        this.inStock = inStock;
        this.description = description;
        this.review = review;
        this.detailAuthor = detailAuthor;
        this.point = point;
        this.isActive = isActive;
    }

    public Book1(String title, String imgURL, float price) {
        this.title = title;
        this.imgResource = imgURL;
        this.price = price;
    }

    public Book1() {

    }

    protected Book1(Parcel in) {
        id = in.readString();
        title = in.readString();
        author = in.readString();
        category = in.readString();
        imgResource = in.readString();
        price = in.readFloat();
        inStock = in.readInt();
        description = in.readString();
        review=in.readString();
        isActive = in.readString();
        detailAuthor = in.readString();
        point = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", imgURL='" + imgResource + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                ", detailAuthor='" + detailAuthor + '\'' +
                ", point='" + point + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(category);
        parcel.writeString(imgResource);
        parcel.writeFloat(price);
        parcel.writeInt(inStock);
        parcel.writeString(review);
        parcel.writeString(detailAuthor);
        parcel.writeString(point);
        parcel.writeString(description);
        parcel.writeString(isActive);
    }

    public String isActive() {
        return this.isActive;
    }

}