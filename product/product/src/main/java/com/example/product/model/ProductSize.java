package com.example.product.model;

public class ProductSize {
    private int id;
    private String sizeCode;
    private String sizeName;
    private String describe;

    public ProductSize() {
    }

    public ProductSize(int id, String sizeCode, String sizeName, String describe) {
        this.id = id;
        this.sizeCode = sizeCode;
        this.sizeName = sizeName;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
