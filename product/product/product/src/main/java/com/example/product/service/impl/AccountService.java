package com.example.product.service.impl;

import com.example.product.repository.IAccountRepo;
import com.example.product.repository.impl.AccountRepo;
import com.example.product.service.IAccountService;

public class AccountService implements IAccountService {
    private final IAccountRepo accountRepo = new AccountRepo();
    @Override
    public boolean checkAccount(String username, String password) {
        return accountRepo.checkAccount(username, password);
    }

    @Override
    public boolean isUsernameExist(String username) {
        return accountRepo.isUsernameExist(username);
    }

    @Override
    public void addNewUserPassword(String username, String password) {
        accountRepo.addNewUserPassword(username, password);
    }

    @Override
    public int getIdAccount(String username) {
        return accountRepo.getIdAccount(username);
    }

    @Override
    public int getAccType(String username) {
        return accountRepo.getAccType(username);
    }

    @Override
    public void addNewCustomer(String code, String name, String email, String phone, String address, String gender, int idNumber) {
        accountRepo.addNewCustomer(code, name, email,phone, address, gender, idNumber);
    }
}
