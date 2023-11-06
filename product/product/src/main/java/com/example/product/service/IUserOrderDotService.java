package com.example.product.service;



import com.example.product.model.UserOrderDot;

import java.sql.Date;
import java.util.List;

public interface IUserOrderDotService {
    List<UserOrderDot> getAllUserOrder();
    List<String> getAllState();
    List<UserOrderDot> getAllUserOrderWith(String code, Date fromDate, Date toDate, String state);
}
