package com.example.bansach.model;

public class OrderDetail {
    private int IdOrder;
    private int IdUser;
    private String orderTime;
    private int pointOfOrder;
    private String orderStatus;
    private int idOrder;
    private int idBook;
    private int number;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String avatarImage;
    private int level;
    private int point;
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
    private int isActive;

    // Constructor to initialize the properties
    public OrderDetail(int IdOrder, int IdUser, String orderTime, int pointOfOrder, String orderStatus,
                       int idOrder, int idBook, int number, String password, String name, String phone,
                       String address, String avatarImage, int level, int point, String title, String author,
                       String category, String imgResource, float price, int inStock, String description,
                       String review, String detailAuthor, int pointOfBook, String URLaudioBook, String sampleRead,
                       int isActive) {
        this.IdOrder = IdOrder;
        this.IdUser = IdUser;
        this.orderTime = orderTime;
        this.pointOfOrder = pointOfOrder;
        this.orderStatus = orderStatus;
        this.idOrder = idOrder;
        this.idBook = idBook;
        this.number = number;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.avatarImage = avatarImage;
        this.level = level;
        this.point = point;
        this.title = title;
        this.author = author;
        this.category = category;
        this.imgResource = imgResource;
        this.price = price;
        this.inStock = inStock;
        this.description = description;
        this.review = review;
        this.detailAuthor = detailAuthor;
        this.pointOfBook = pointOfBook;
        this.URLaudioBook = URLaudioBook;
        this.sampleRead = sampleRead;
        this.isActive = isActive;
    }

    // Getter and Setter methods for all properties
    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getPointOfOrder() {
        return pointOfOrder;
    }

    public void setPointOfOrder(int pointOfOrder) {
        this.pointOfOrder = pointOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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

    public void setImgResource(String imgResource) {
        this.imgResource = imgResource;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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

    public int getPointOfBook() {
        return pointOfBook;
    }

    public void setPointOfBook(int pointOfBook) {
        this.pointOfBook = pointOfBook;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
