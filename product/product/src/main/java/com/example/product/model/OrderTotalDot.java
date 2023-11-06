package com.example.product.model;

import java.sql.Date;

public class OrderTotalDot {
    private String orderCode;
    private Date orderDate;
    private String orderAddress;
    private String orderPhone;
    private double orderTotal;

    public OrderTotalDot() {
    }

    public OrderTotalDot(String orderCode, Date orderDate, String orderAddress, String orderPhone, double orderTotal) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.orderTotal = orderTotal;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
