package com.example.product.repository.impl;



import com.example.product.model.OrderTotalDot;
import com.example.product.repository.IOrderTotalDot;
import com.example.product.utils.Util;

import java.sql.*;

public class OrderTotalDotRepo implements IOrderTotalDot {
    private String GET_ORDER_TOTAL = "CALL total_bill(?);";
    @Override
    public OrderTotalDot getOrderTotal(String code1) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_ORDER_TOTAL);
            callableStatement.setString(1, code1);
            ResultSet resultSet = callableStatement.executeQuery();
            if(resultSet.next()){
                String code = resultSet.getString("ma_don_hang");
                Date date = resultSet.getDate(2);
                String address =  resultSet.getString(3);
                String phone = resultSet.getString(4);
                double total = resultSet.getDouble(5);
                OrderTotalDot orderTotalDot = new OrderTotalDot(code,date,address,phone,total);
                return orderTotalDot;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
