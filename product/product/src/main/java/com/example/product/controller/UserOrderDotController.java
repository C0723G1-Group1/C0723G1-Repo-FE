package com.example.product.controller;



import com.example.product.model.OrderDetailDot;
import com.example.product.model.OrderTotalDot;
import com.example.product.model.UserOrderDot;
import com.example.product.service.IOrderDetailDotService;
import com.example.product.service.IOrderTotalDotService;
import com.example.product.service.IUserOrderDotService;
import com.example.product.service.impl.OrderDetailDotService;
import com.example.product.service.impl.OrderTotalDotService;
import com.example.product.service.impl.UserOrderDotService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "UserOrderDotController", value = "/user_order")
public class UserOrderDotController extends HttpServlet {
    private IUserOrderDotService orderDotService = new UserOrderDotService();
    private IOrderDetailDotService orderDetailDotService = new OrderDetailDotService();
    private IOrderTotalDotService orderTotalDotService = new OrderTotalDotService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add": break;
            case "search": showAllByS(request, response);
            break;
            default: showAll(request, response);
            break;
        }
    }

    private void showAllByS(HttpServletRequest request, HttpServletResponse response) {
        List<UserOrderDot> orderDotList;
        List<String> states = orderDotService.getAllState();
        String code = request.getParameter("madh");
        Date fromDate = null;
        Date toDate = null;
        String state =request.getParameter("state") ;
        if(!request.getParameter("formDate").equals("")){
            fromDate = Date.valueOf(request.getParameter("formDate"));
        }
        if(!request.getParameter("toDate").equals("")){
            toDate = Date.valueOf(request.getParameter("toDate"));
        }
        if(request.getParameter("state").equals("all")){
            state ="";
        }
        orderDotList = orderDotService.getAllUserOrderWith(code, fromDate, toDate, state);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("orderDotList",orderDotList);
        request.setAttribute("orderDotList",orderDotList);
        request.setAttribute("states", states);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<UserOrderDot> orderDotList = orderDotService.getAllUserOrder();
        List<String> states = orderDotService.getAllState();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("orderDotList",orderDotList);
        request.setAttribute("states", states);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add": break;
            case "detail":
                showDetail(request, response);
                break;
            default: showAll(request, response);
                break;
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        String code_dh = request.getParameter("code_dh");
        List<OrderDetailDot> orderDetailDotList = orderDetailDotService.getAll(code_dh);
        OrderTotalDot orderTotalDot = orderTotalDotService.getOrderTotal(code_dh);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/detail.jsp");
        request.setAttribute("orderDetailDotList", orderDetailDotList);
        request.setAttribute("orderTotalDot", orderTotalDot);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
