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

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerOrderController", value = "/customer-order")
public class CustomerOrderController extends HttpServlet {
    private final IUserOrderDotService userOrderDotService = new UserOrderDotService();
    private IOrderDetailDotService orderDetailDotService = new OrderDetailDotService();
    private IOrderTotalDotService orderTotalDotService = new OrderTotalDotService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "search":
                searchByCus(request, response);
                break;
            default: getAllOrderOfCus(request, response);
                break;
        }
    }

    private void searchByCus(HttpServletRequest request, HttpServletResponse response) {
        List<UserOrderDot> orderDotList;
        List<String> states = userOrderDotService.getAllState();
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
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("account");
        orderDotList = userOrderDotService.getAllUserOrderWithUsername(username,code, fromDate, toDate, state);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer-order.jsp");
        request.setAttribute("orderDotList",orderDotList);
        request.setAttribute("states", states);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllOrderOfCus(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("account");
        List<UserOrderDot> userOrderDotList =  userOrderDotService.getAllOrderByUsername(username);
        List<String> states = userOrderDotService.getAllState();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer-order.jsp");
        request.setAttribute("orderDotList",userOrderDotList);
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
            default: getAllOrderOfCus(request, response);
                break;
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        String code_dh = request.getParameter("code_dh");
        List<OrderDetailDot> orderDetailDotList = orderDetailDotService.getAll(code_dh);
        OrderTotalDot orderTotalDot = orderTotalDotService.getOrderTotal(code_dh);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/order_detail_of_customer.jsp");
        request.setAttribute("orderDetailDotList", orderDetailDotList);
        request.setAttribute("orderTotalDot", orderTotalDot);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
