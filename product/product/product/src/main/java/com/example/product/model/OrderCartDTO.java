package com.example.product.model;

public class OrderCartDTO {
    private String productName;
    private String productCode;
    private String linkPath;
    private int quantity;
    private int provisional;

    public OrderCartDTO() {
    }

    public OrderCartDTO(String productName, String productCode, String linkPath, int quantity, int provisional) {
        this.productName = productName;
        this.productCode = productCode;
        this.linkPath = linkPath;
        this.quantity = quantity;
        this.provisional = provisional;
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

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String link_path) {
        this.linkPath = linkPath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProvisional() {
        return provisional;
    }

    public void setProvisional(int provisional) {
        this.provisional = provisional;
    }
}
