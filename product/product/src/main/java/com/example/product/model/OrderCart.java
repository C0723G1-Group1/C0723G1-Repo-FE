package com.example.product.model;

public class OrderCart {
    private int id;
    private int idAccount;
    private int idProduct;
    private int quantity;

    public OrderCart(int id, int idAccount, int idProduct, int quantity) {
        this.id = id;
        this.idAccount = idAccount;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public OrderCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
