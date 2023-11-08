package com.example.product.repository;

public interface IAccountRepo {
    boolean checkAccount(String username, String password);
    boolean isUsernameExist(String username);

    void addNewUserPassword(String username, String password);
    int getIdAccount(String username);

    void addNewCustomer(String code, String name, String email, String phone, String address, String gender, int idNumber);
    int getAccType(String username);
}
