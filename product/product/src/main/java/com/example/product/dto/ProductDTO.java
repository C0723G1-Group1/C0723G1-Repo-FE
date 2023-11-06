package com.example.product.dto;

import java.util.List;

public class ProductDTO {
    private String productName;
    private String productCode;
    private String material;
    private int gia;
    private List<String> image;


    public ProductDTO() {
    }

//    public ProductDTO(String productName, String material, int gia, List<String> image) {
//        this.productName = productName;
//        this.material = material;
//        this.gia = gia;
//        this.image = image;
//    }

    public ProductDTO(String productName, String productCode, String material, int gia, List<String> image) {
        this.productName = productName;
        this.productCode = productCode;
        this.material = material;
        this.gia = gia;
        this.image = image;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
