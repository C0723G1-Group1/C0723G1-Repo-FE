package com.example.product.repository;



import com.example.product.model.UserOrderDot;

import java.sql.Date;
import java.util.List;

public interface IUserOrderDotRepo {
    List<UserOrderDot> getAllUserOrder();
    List<UserOrderDot> getAllOrderByUsername(String username);
    List<String> getAllState();
    List<UserOrderDot> getAllUserOrderWith(String code, Date fromDate, Date toDate, String state);
    List<UserOrderDot> getAllUserOrderWithUsername(String username,String code, Date fromDate, Date toDate, String state);
}
