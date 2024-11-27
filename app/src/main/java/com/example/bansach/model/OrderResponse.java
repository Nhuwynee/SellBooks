package com.example.bansach.model;

public class OrderResponse {
    private boolean success;
    private String message;
    private int idOrder;

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getIdOrder() {
        return idOrder;
    }
}
