package com.example.product.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelOrderByAdmin {
    public static int getIdOrderByCode(String code){
        String sql = "select id from don_hang where ma_don_hang = '" + code +"'";
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void cancelOrder(int id){
        String sql = "update don_hang set trang_thai_van_chuyen = 'Huỷ' where id = " +id;
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
