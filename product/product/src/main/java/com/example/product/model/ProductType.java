package com.example.product.model;

public class ProductType {
    private int id;
    private String productTypeCode;
    private String productTypeName;
    private String describe;

    public ProductType() {
    }

    public ProductType(int id, String productTypeCode, String productTypeName, String describe) {
        this.id = id;
        this.productTypeCode = productTypeCode;
        this.productTypeName = productTypeName;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
