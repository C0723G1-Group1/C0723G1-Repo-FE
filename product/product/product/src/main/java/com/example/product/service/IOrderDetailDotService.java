package com.example.product.service;



import com.example.product.model.OrderDetailDot;

import java.util.List;

public interface IOrderDetailDotService {
    List<OrderDetailDot> getAll(String code);
}
