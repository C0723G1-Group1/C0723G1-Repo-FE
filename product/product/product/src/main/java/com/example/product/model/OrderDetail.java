package com.example.product.model;

public class OrderDetail {
    private int id;
    private String orderDetailCode;
    private int idOrder;
    private int idProduct;
    private int price;
    private int quantity;

    public OrderDetail(int id, String orderDetailCode, int idOrder, int idProduct, int price, int quantity) {
        this.id = id;
        this.orderDetailCode = orderDetailCode;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail(String orderDetailCode, int idOrder, int idProduct, int price, int quantity) {
        this.orderDetailCode = orderDetailCode;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
