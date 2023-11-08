package com.example.product.service.impl;


import com.example.product.model.OrderTotalDot;
import com.example.product.repository.IOrderTotalDot;
import com.example.product.repository.impl.OrderTotalDotRepo;
import com.example.product.service.IOrderTotalDotService;

public class OrderTotalDotService implements IOrderTotalDotService {
    IOrderTotalDot orderTotalDot = new OrderTotalDotRepo();

    @Override
    public OrderTotalDot getOrderTotal(String code) {
        return orderTotalDot.getOrderTotal(code);
    }
}
