package com.example.product.model;

public class OrderDetailDot {
    private String imageLink;
    private String productName;
    private String productCode;
    private int productQuality;
    private float productPrice;
    private double total;

    public OrderDetailDot() {
    }

    public OrderDetailDot(String imageLink, String productName, String productCode, int productQuality, float productPrice, double total) {
        this.imageLink = imageLink;
        this.productName = productName;
        this.productCode = productCode;
        this.productQuality = productQuality;
        this.productPrice = productPrice;
        this.total = total;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(int productQuality) {
        this.productQuality = productQuality;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
