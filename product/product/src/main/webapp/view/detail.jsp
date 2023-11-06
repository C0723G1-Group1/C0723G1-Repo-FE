<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/3/2023
  Time: 4:42 PM
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
      text-align: center;
    }
    h3{
      font-size: 15px;
      font-family: 'Roboto', sans-serif;
      text-transform: uppercase;
      font-weight: 600;
    }
    .btn-outline-secondary {
      font-size: 15px;
      padding: 3px 3px;
    }
    .font-b{
      font-family: 'Roboto', sans-serif;
      font-weight: 600;
      font-size: 14px;
    }
    .font-c{
      font-family: 'Roboto', sans-serif;
      font-size: 14px;
    }
    .text-of-bill{
      font-family: 'Roboto', sans-serif;
      font-size: 14px;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-white px-5">
  <div class="container-fluid p-0">
    <div>
      <a class="navbar-brand" href="#">
        <img src="FBDBc3UVcAczrDS.jpeg" height="100" width="130"/></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
    <div style="margin: 0 auto">
      <div class="collapse navbar-collapse ">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li>
            <a class="nav-link active" aria-current="page" href="#" style="color: black">Trang sức
              bạc</a>
          </li>
          <li>
            <a class="nav-link" href="#" style="color: black"> Trang sức vàng </a>
          </li>
          <li>
            <a class="nav-link" href="#" style="color: black">Nhẫn cưới </a>
          </li>
          <li>
            <a class="nav-link" href="#" style="color: black">Thành Viên </a>
          </li>
        </ul>

      </div>

    </div>
    <div>

      <ul class="navbar-nav d-flex me-auto mb-2 mb-lg-0 right">
        <li>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
            <button class="btn " type="submit"><i class="fa-solid fa-magnifying-glass"></i>
            </button>
          </form>
        </li>
        <li class="nav-item " style="margin-right: 2%">
          <button class="btn"><i class="fa-solid fa-cart-shopping"></i></button>

        </li>
        <li class="nav-item " style="margin-right: 2%">
          <button class="btn"><i class="fa-regular fa-user"></i></button>
      </ul>
    </div>
  </div>
</nav>
<div class="m-3">
  <h2 class="title-h2 ">CHI TIẾT ĐƠN HÀNG</h2>
  <div><button type="button" class="btn btn-outline-secondary" onclick="goBack()">Quay lại</button></div>
  <div class="row">
    <div class="col-md-7">
      <c:forEach items="${orderDetailDotList}" var="order">
      <div class="row">
        <div class="col-md-3">
          <img src="${order.imageLink}" height="90%" width="90%"/>
        </div>
        <div class="col-md-9 my-3">
          <h3>${order.productName}</h3>
          <div><span class="font-b">MSP: </span><span class="font-c">${order.productCode}</span></div>
          <div><span class="font-b">Số lượng: </span><span class="font-c">${order.productQuality}</span></div>
          <div><span class="font-b">Giá mua: </span><span class="font-c">${order.productPrice}</span></div>
          <div><span class="font-b">Thành tiền: </span><span class="font-c">${order.total}</span></div>
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="col-md-5" >
      <table class="table text-of-bill" style="background-color: #F2F2F2">
        <tbody>
        <tr>
          <td>Mã đơn hàng:</td>
          <td>${orderTotalDot.orderCode}</td>
        </tr>
        <tr>
          <td>Ngày đặt hàng:</td>
          <td>${orderTotalDot.orderDate}</td>
        </tr>
        <tr>
          <td>Địa chỉ nhận:</td>
          <td>${orderTotalDot.orderAddress}</td>
        </tr>
        <tr>
          <td>Số điện thoại:</td>
          <td>${orderTotalDot.orderPhone}</td>
        </tr>
        <tr>
          <td>Tổng tiền:</td>
          <td>${orderTotalDot.orderTotal}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>

</div>
<script>
  function goBack() {
    window.location.href = '/user_order';
  }
</script>
</body>
</html>
