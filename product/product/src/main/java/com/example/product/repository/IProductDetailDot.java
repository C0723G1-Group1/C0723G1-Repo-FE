package com.example.product.repository;

import com.example.product.model.OrderDetailDot;

import java.util.List;

public interface IProductDetailDot {
    List<OrderDetailDot> getAll(String code);
}
