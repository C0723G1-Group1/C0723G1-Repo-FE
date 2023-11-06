<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/3/2023
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>


        .title-h2 {
            position: relative;
            border-bottom: 1px solid #e0e0e0;
            margin-bottom: 15px;
            display: block;
            color: #212529;
            transition: 0.3s linear;
            font-size: 22px;
            font-family: 'Roboto', sans-serif;
            text-transform: uppercase;
            font-weight: 600;
        }


        .b1 {
            font-size: 12px;
            font-family: 'Roboto', sans-serif;
        }

        .left1 td {
            font-size: 14px;
            font-family: 'Roboto', sans-serif;
        }

        .btn-outline-secondary {
            font-size: 12px;
            padding: 3px 3px;
        }
    </style>
</head>
<div>
<c:import url="navbar.jsp"></c:import>
<div class = "row m-4">
<c:import url="menu-admin.jsp"></c:import>
    <div class="col-md-10 col-sm-12">
        <h2 class="title-h2">ĐƠN HÀNG</h2>
        <form action="/user_order">
            <div class="row b1">
                <div class="col-md-2 col-sm-6">
                    <p>Mã đơn hàng</p>
                    <input name="madh" class="form-control form-control-sm b1" type="text"
                           placeholder="Example"
                           aria-label=".form-control-sm example">
                </div>
                <div class="col-md-2 col-sm-6">
                    <p>Thời hạn</p>
                    <select name="date" class="form-select form-select-sm b1" aria-label="Small select example">
                        <option value="all" selected>Tất cả</option>
                        <option value="1">1 ngày</option>
                        <option value="2">2 ngày</option>
                        <option value="3">3 ngày</option>
                        <option value="4">4 ngày</option>
                        <option value="5">5 ngày</option>
                    </select>
                </div>
                <div class="col-md-2 col-sm-6">
                    <p>Chọn ngày</p>
                    <input name="formDate" class="form-control form-control-sm b1" type="date" placeholder="yyyy-mm-dd"
                           aria-label=".form-control-sm example">
                </div>
                <div class="col-md-2 col-sm-6">
                    <p>Đến ngày</p>
                    <input name="toDate" class="form-control form-control-sm b1" type="date" placeholder="dd/mm/yyyy"
                           aria-label=".form-control-sm example">
                </div>
                <div class="col-md-2 col-sm-6">
                    <p>Trạng thái đơn hàng</p>
                    <select name = "state" class="form-select form-select-sm b1" aria-label="Small select example">
                        <option value="all" selected>All</option>
                        <c:forEach items="${states}" var="state">
                        <option value="${state}">${state}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-2 col-sm-6">
                    <div class="py-4">
                        <button name="action" value="search" type="submit" class="btn btn-outline-danger bt b1" style="height: 30.33px">Tìm kiếm
                        </button>
                    </div>

                </div>
            </div>
        </form>
        <div class="b1">
            <form action="/user_order" method="post">
            <table class="table table-striped table-hover">
                <thead style="font-size: 14px">
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Ngày đặt hàng</th>
                    <th>Tình trạng đơn hàng</th>
                    <th>Tổng thanh toán</th>
                    <th>Chi tiết</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderDotList}" var="order" varStatus="status">
                    <tr>
                        <td>${order.orderCode}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.orderState}</td>
                        <td>${order.orderTotal}</td>
                        <td><button name="code_dh" value="${order.orderCode}" type="submit" class="btn btn-outline-secondary" formaction="/user_order?action=detail">
                            Chi tiết
                        </button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"></c:import>
</div>
</body>
</html>
