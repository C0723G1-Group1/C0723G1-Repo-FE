package com.example.product.repository.impl;

import com.example.product.repository.IAccountRepo;
import com.example.product.utils.Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepo implements IAccountRepo {
    private final String GET_ALL_ACC = "call get_account(?,?);";
    private final String GET_USER_BY_USER = "call get_account_by_username(?);";
    private final String ADD_NEW_ACC = "call add_new_account(?,?)";
    private final String GET_ID_ACC = "call get_id_tai_khoan(?)";
    private final String ADD_NEW_CUSTOMER = "call add_new_customer(?,?,?,?,?,?,?);";
    private final String GET_ACC_TYPE = "call get_account_type(?);";
    @Override
    public boolean checkAccount(String username, String password) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_ALL_ACC);
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            ResultSet resultSet = callableStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean isUsernameExist(String username) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_USER);
            callableStatement.setString(1, username);
            ResultSet resultSet = callableStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void addNewUserPassword(String username, String password) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_ACC);
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getIdAccount(String username) {
        Connection connection = Util.getConnectDB();
        try {
            int id = 0;
            CallableStatement callableStatement = connection.prepareCall(GET_ID_ACC);
            callableStatement.setString(1, username);
            ResultSet resultSet = callableStatement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCustomer(String code, String name, String email, String phone,
                               String address, String gender, int idNumber) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_CUSTOMER);
            callableStatement.setString(1, code);
            callableStatement.setString(2, name);
            callableStatement.setString(3, email);
            callableStatement.setString(4, phone);
            callableStatement.setString(5, address);
            callableStatement.setString(6, gender);
            callableStatement.setInt(7, idNumber);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getAccType(String username) {
        Connection connection = Util.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_ACC_TYPE);
            callableStatement.setString(1, username);
            ResultSet resultSet = callableStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
