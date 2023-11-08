package com.example.product.service.impl;



import com.example.product.model.UserOrderDot;
import com.example.product.repository.IUserOrderDotRepo;
import com.example.product.repository.impl.UserOrderDotRepo;
import com.example.product.service.IUserOrderDotService;

import java.sql.Date;
import java.util.List;

public class UserOrderDotService implements IUserOrderDotService {
    IUserOrderDotRepo userOrderDotRepo = new UserOrderDotRepo();
    @Override
    public List<UserOrderDot> getAllUserOrder() {
        return userOrderDotRepo.getAllUserOrder();
    }

    @Override
    public List<UserOrderDot> getAllOrderByUsername(String username) {
        return userOrderDotRepo.getAllOrderByUsername(username);
    }

    @Override
    public List<String> getAllState() {
        return userOrderDotRepo.getAllState();
    }

    @Override
    public List<UserOrderDot> getAllUserOrderWith(String code, Date fromDate, Date toDate, String state) {
        return userOrderDotRepo.getAllUserOrderWith(code, fromDate, toDate, state);
    }

    @Override
    public List<UserOrderDot> getAllUserOrderWithUsername(String username, String code, Date fromDate, Date toDate, String state) {
        return userOrderDotRepo.getAllUserOrderWithUsername(username, code, fromDate, toDate, state);
    }
}
