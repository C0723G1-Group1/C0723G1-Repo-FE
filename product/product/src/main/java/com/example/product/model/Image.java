package com.example.product.model;

public class Image {
    private int id;
    private String linkPath;
    private int idProduct;

    public Image(int id, String linkPath, int idProduct) {
        this.id = id;
        this.linkPath = linkPath;
        this.idProduct = idProduct;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
