package com.example.bansach.model;

import java.util.Date;

public class History {
    private String orderNumber;
    private Date orderDate;
    private int orderPrice;
    private String orderStatus;
    private String statusIcon;

    // Constructor, getters và setters
    public History(String orderNumber, Date orderDate, int orderPrice, String orderStatus, String statusIcon) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.statusIcon = statusIcon;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate; // Getter cho orderDate
    }

    public int getOrderPrice() {
        return orderPrice; // Getter cho orderPrice
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getStatusIcon() {
        return statusIcon; // Getter cho status icon
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setStatusIcon(String statusIcon) {
        this.statusIcon = statusIcon;
    }
}
