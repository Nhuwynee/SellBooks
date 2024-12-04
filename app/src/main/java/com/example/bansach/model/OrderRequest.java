package com.example.bansach.model;

import java.util.List;

public class OrderRequest {
    private int IdUser;
    private double pointOfOrder;
    private List<Orderitem> orderDetails;
    private  int point;

    public OrderRequest(int IdUser, double pointOfOrder, List<Orderitem> orderDetails, int point) {
        this.IdUser = IdUser;
        this.pointOfOrder = pointOfOrder;
        this.orderDetails = orderDetails;
        this.point = point;
    }

    public static class Orderitem {
        private int idBook;
        private int number;

        public Orderitem(int idBook, int number) {
            this.idBook = idBook;
            this.number = number;
        }
    }
}
