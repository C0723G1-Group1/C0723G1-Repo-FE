package com.example.product.service;

public interface IAccountService {
    boolean checkAccount(String username, String password);
    boolean isUsernameExist(String username);
    void addNewUserPassword(String username, String password);
    int getIdAccount(String username);
    int getAccType(String username);
    void addNewCustomer(String code, String name, String email, String phone, String address, String gender, int idNumber);
}
