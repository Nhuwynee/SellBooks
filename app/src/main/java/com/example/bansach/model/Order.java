package com.example.bansach.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("IdOrder") // Ánh xạ trường từ JSON
    private int idOrder;

    @SerializedName("IdUser")
    private int idUser;

    @SerializedName("orderTime")
    private String orderTime;

    @SerializedName("pointOfOrder")
    private double pointOfOrder;

    @SerializedName("orderStatus")
    private String orderStatus;

    // Getter và Setter
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getPointOfOrder() {
        return pointOfOrder;
    }

    public void setPointOfOrder(double pointOfOrder) {
        this.pointOfOrder = pointOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
