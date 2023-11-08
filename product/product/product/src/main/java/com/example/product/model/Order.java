package com.example.product.model;


public class Order {
    private int id;
    private String orderCode;
    private int idAccount;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String orderDate;
    private String deliveryDate;
    private String statusTransfer;
    private int payCode;

    public Order() {
    }

    public Order(int idAccount, String name, String phone, String address, String email, String orderDate, String statusTransfer, int payCode) {
        this.idAccount = idAccount;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.orderDate = orderDate;
        this.statusTransfer = statusTransfer;
        this.payCode = payCode;
    }

    public Order(int id, String orderCode, int idAccount, String name, String phone, String address, String email, String orderDate, String deliveryDate, String statusTransfer, int payCode) {
        this.id = id;
        this.orderCode = orderCode;
        this.idAccount = idAccount;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.statusTransfer = statusTransfer;
        this.payCode = payCode;
    }

    public Order(String orderCode, int idAccount, String name, String phone, String address, String email, String orderDate, String statusTransfer, int payCode) {
        this.orderCode = orderCode;
        this.idAccount = idAccount;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.orderDate = orderDate;
        this.statusTransfer = statusTransfer;
        this.payCode = payCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatusTransfer() {
        return statusTransfer;
    }

    public void setStatusTransfer(String statusTransfer) {
        this.statusTransfer = statusTransfer;
    }

    public int getPayCode() {
        return payCode;
    }

    public void setPayCode(int payCode) {
        this.payCode = payCode;
    }
}
