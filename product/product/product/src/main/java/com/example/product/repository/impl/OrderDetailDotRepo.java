package com.example.product.repository.impl;



import com.example.product.model.OrderDetailDot;
import com.example.product.repository.IProductDetailDot;
import com.example.product.utils.Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDotRepo implements IProductDetailDot {
    private final String SELECT_ALL_ORDER_STORE = "call chi_tiet_don_hang(?);";
    @Override
    public List<OrderDetailDot> getAll(String code1) {
        List<OrderDetailDot> orderDetailDotList = new ArrayList<>();
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_ORDER_STORE);
            callableStatement.setString(1,code1);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String link = resultSet.getString("link_path");
                String name = resultSet.getString("ten_san_pham");
                String code = resultSet.getString("ma_san_pham");
                int quality = resultSet.getInt("so_luong");
                float price = resultSet.getFloat("gia_mua");
                double total = resultSet.getDouble("tong");
                orderDetailDotList.add(new OrderDetailDot(link, name, code, quality, price, total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailDotList;
    }
}
