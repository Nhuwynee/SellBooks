package com.example.bansach.model;

public class User {
    private int idUser;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String avatarImage;
    private int level;
    private  int point;

    public User() {

        
    }

    public User(String name, String phone, String address, String password) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    // Getter và Setter
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    // Override phương thức toString để dễ dàng debug
    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", avatarImage='" + avatarImage + '\'' +
                ", level=" + level +
                '}';
    }
}