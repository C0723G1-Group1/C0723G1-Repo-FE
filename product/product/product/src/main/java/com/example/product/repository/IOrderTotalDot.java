package com.example.product.repository;


import com.example.product.model.OrderTotalDot;

public interface IOrderTotalDot {
    OrderTotalDot getOrderTotal(String code);
}
