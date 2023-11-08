<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/6/2023
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .h1-hover:hover {
            color: red;
        }

        a {
            text-decoration: none;

        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<c:import url="navbar.jsp"></c:import>
<div class="mx-1">
    <h3 class="h1-hover m-3">GIỎ HÀNG</h3>
    <hr>
    <a href="/products">
        <button class="btn btn-outline-secondary m-3"><-- TIẾP TỤC MUA HÀNG</button>
    </a>
    <div class="row m-3">
        <div class="col-12 col-sm-8 col-md-8">
            <input type="hidden" id="length" value="${orderCartDTOList.size()}">
            <c:forEach var="cart" items="${orderCartDTOList}" varStatus="count">
                <c:set var="price" value="${cart.provisional / cart.quantity}"></c:set>
                <c:set var="sum" value="${sum + cart.provisional}"/>
                <div class="row m-3">
                    <div class="col-12 col-sm-3 col-md-3 w-25 border d-flex justify-content-center">
                        <img class="w-75"
                             src="${cart.linkPath}">
                    </div>
                    <div class="col-12 col-sm-9 col-md-9 ">
                        <a href="/products?action=detail&id=${cart.productCode}" class="text-black">
                            <h3>${cart.productName}</h3></a>
                        <p class="h5">MSP : ${cart.productCode}</p>
                        <div class="form-group d-flex align-items-center">
                            <h5 class="h5">Số lượng</h5>
                            <div class="btn-group dropend">
                                <div class="form-outline my-1" style="width: 5rem;">
                                    <input id="count-${count.index}" onchange="calculateValue(${count.index})"
                                           value=${cart.quantity} type="number" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex">
                            <p class="h5">Tạm tính:</p>
                            <p class="mx-2 h5 text-danger" id="result-${count.index}">${cart.provisional}</p>
                            <input type="hidden" id="current-${count.index}" value="${cart.provisional}">
                            <input type="hidden" value="${price}" id="price-${count.index}">
                        </div>
                        <a href="#" onclick="setModal('${orderCartList[count.index].id}')" class="mx-1 h5"
                           data-bs-toggle="modal" data-bs-target="#xoa1">Xóa</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-12 col-sm-4 col-md-4 border w-25 " style="background-color: #f2f2f2">
            <h5 class="my-4">Tổng tiền</h5>
            <div class="d-flex justify-content-between">
                <h5>Tạm tính:</h5>
                <p class="mx-1 h5" id="sum1">${sum}</p>
            </div>
            <hr>
            <div class="d-flex justify-content-between">
                <h5>Vận chuyển:</h5>
                <p class="mx-1 h5">Miễn phí vận chuyển</p>
            </div>
            <hr>
            <div class="d-flex justify-content-between">
                <p class="h5">Giảm giá member</p>
                <p class="h5">Diamond</p>
            </div>
            <hr>
            <div class="d-flex justify-content-between">
                <p class="h5">Thành tiền</p>
                <p class="h5" id="sum">${sum}</p>
            </div>
            <div class="d-block justify-content-center align-content-center my-5">
                <button class="w-100 bg-danger text-light py-2 border-0">TIẾN HÀNH ĐẶT HÀNG</button>
            </div>
        </div>
    </div>
    <hr>
</div>
<c:import url="footer.jsp"></c:import>
<div class="modal" tabindex="-1" id="xoa1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-body">
                <h5 style="text-align: center">Bạn có muốn xóa sản phẩm này ?</h5>
            </div>
            <div class="modal-footer d-flex justify-content-center">
                <a href="#">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Không</button>
                </a>
                <a id="id1">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Có</button>
                </a>
            </div>
        </div>
    </div>
</div>
<script>
    function calculateValue(index) {

        const productCount = document.getElementById("count-" + index).value;
        const productPrice = +document.getElementById("price-" + index).value;
        document.getElementById("result-" + index).innerText = productCount * productPrice;
        document.getElementById("current-" + index).value = productCount * productPrice;

        const length = +document.getElementById("length").value;
        let total = 0;
        for (let i = 0; i < length; i++) {
            let price = +document.getElementById("current-" + i).value;
            total += price;
        }
        document.getElementById("sum").innerText = String(total)
        document.getElementById("sum1").innerText = String(total)

    }
</script>
<script>
    function setModal(id) {
        console.log(id)
        document.getElementById("id1").setAttribute("href", `/products?action=delete-cart&id=` + id);
    }
</script>
</body>
</html>
