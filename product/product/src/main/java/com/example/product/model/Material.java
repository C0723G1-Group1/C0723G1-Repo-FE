package com.example.product.model;

public class Material {
    private int id;
    private String materialCode;
    private String materialName;
    private String describe;

    public Material() {
    }

    public Material(int id, String materialCode, String materialName, String describe) {
        this.id = id;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
