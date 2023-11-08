package com.example.product.repository.impl;



import com.example.product.model.UserOrderDot;
import com.example.product.repository.IUserOrderDotRepo;
import com.example.product.utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserOrderDotRepo implements IUserOrderDotRepo {
    private final String SELECT_ALL_STORE = "call get_order_by_customer_id();";
    private final String SELECT_ALL_STATE = "select distinct trang_thai_van_chuyen " +
            "from don_hang;";
    private final String SELECT_ALL_ORDER_BY_USERNAME = "call get_order_by_username(?);";
    @Override
    public List<UserOrderDot> getAllUserOrder() {
        List<UserOrderDot> userOrderDotList = new ArrayList<>();
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_STORE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String ma = resultSet.getString("ma_don_hang");
                String date = resultSet.getString("ngay_dat_hang");
                String state = resultSet.getString("trang_thai_van_chuyen");
                float total = resultSet.getFloat("total");
                userOrderDotList.add(new UserOrderDot(id, ma, date, state,total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userOrderDotList;
    }

    @Override
    public List<UserOrderDot> getAllOrderByUsername(String username) {
        List<UserOrderDot> userOrderDotList = new ArrayList<>();
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_ORDER_BY_USERNAME);
            callableStatement.setString(1, username);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String ma = resultSet.getString("ma_don_hang");
                String date = resultSet.getString("ngay_dat_hang");
                String state = resultSet.getString("trang_thai_van_chuyen");
                float total = resultSet.getFloat("total");
                userOrderDotList.add(new UserOrderDot(ma, date, state, total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userOrderDotList;
    }

    @Override
    public List<String> getAllState() {
        List<String> listStates = new ArrayList<>();
        String state;
        Connection connection = Util.getConnectDB();

        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_STATE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                state = resultSet.getString(1);
                listStates.add(state);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listStates;
    }

    @Override
    public List<UserOrderDot> getAllUserOrderWith(String code, Date fromDate, Date toDate, String state) {
        List<UserOrderDot> userOrderDotList = new ArrayList<>();
        String sql = "select dh.id id, ma_don_hang, ngay_dat_hang, trang_thai_van_chuyen, sum(gia * so_luong) total " +
                "from chi_tiet_don_hang ctdh  " +
                "join don_hang dh " +
                "on ctdh.id_don_hang = dh.id " +
                "where 1=1 " ;

        if(code != null && !code.equals("")){
            sql += " and ma_don_hang like '%" + code + "%'";
        }
        if(fromDate != null){
            sql += " and date(ngay_dat_hang) >= '" +fromDate+"'";
        }
        if(toDate != null){
            sql += " and date(ngay_dat_hang) <= '" +toDate+"'";
        }
        if(state != null && !state.equals("")){
            sql += " and trang_thai_van_chuyen  = '"+ state +"'";
        }
        sql += " group by dh.id;";
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String ma = resultSet.getString("ma_don_hang");
                String date = resultSet.getString("ngay_dat_hang");
                String state1 = resultSet.getString("trang_thai_van_chuyen");
                float total = resultSet.getFloat("total");
                userOrderDotList.add(new UserOrderDot(id, ma, date, state1,total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userOrderDotList;
    }

    @Override
    public List<UserOrderDot> getAllUserOrderWithUsername(String username, String code, Date fromDate, Date toDate, String state) {
        List<UserOrderDot> userOrderDotList = new ArrayList<>();
        String sql = "select dh.id id, ma_don_hang, ngay_dat_hang, trang_thai_van_chuyen, sum(gia * so_luong) total  " +
                "   from chi_tiet_don_hang ctdh " +
                "   join don_hang dh  " +
                "  on ctdh.id_don_hang = dh.id " +
                "  join tai_khoan tk " +
                "  on tk.id = dh.id_tai_khoan " ;
        sql += " where user_name = '" + username +"' ";

        if(code != null && !code.equals("")){
            sql += " and ma_don_hang like '%" + code + "%'";
        }
        if(fromDate != null){
            sql += " and date(ngay_dat_hang) >= '" +fromDate+"'";
        }
        if(toDate != null){
            sql += " and date(ngay_dat_hang) <= '" +toDate+"'";
        }
        if(state != null && !state.equals("")){
            sql += " and trang_thai_van_chuyen  = '"+ state +"'";
        }
        sql += " group by dh.id;";
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String ma = resultSet.getString("ma_don_hang");
                String date = resultSet.getString("ngay_dat_hang");
                String state1 = resultSet.getString("trang_thai_van_chuyen");
                float total = resultSet.getFloat("total");
                userOrderDotList.add(new UserOrderDot(id, ma, date, state1,total));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userOrderDotList;
    }
}
