package com.example.product.service.impl;


import com.example.product.model.OrderDetailDot;
import com.example.product.repository.IProductDetailDot;
import com.example.product.repository.impl.OrderDetailDotRepo;
import com.example.product.service.IOrderDetailDotService;

import java.util.List;

public class OrderDetailDotService implements IOrderDetailDotService {
    private IProductDetailDot productDetailDot = new OrderDetailDotRepo();

    @Override
    public List<OrderDetailDot> getAll(String code) {
        return productDetailDot.getAll(code);
    }
}
