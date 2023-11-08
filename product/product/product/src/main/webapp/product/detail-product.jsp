<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/5/2023
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>
        ul {
            list-style-type: none;
        }

        p {
            font-family: Roboto;
        }

        body.new-design .hero .hero-title .eyebrow {
            font-size: 12px;
            line-height: 16px;
            font-weight: 700;
            letter-spacing: -.05em;
            text-transform: uppercase;
            padding-bottom: 0.5rem;
            margin-bottom: 0;
        }

        .hero .hero-title {
            color: #fff;
            font-size: 66px;
            letter-spacing: 2px;
            font-variant-ligatures: none;
            line-height: 70px;
            margin-bottom: 16px;
            position: relative;
            text-transform: uppercase;
            z-index: 25;
        }


        .overline {
            font-size: .625rem;
            letter-spacing: .0625rem;
            line-height: 1rem;
            font-weight: 400;
            text-transform: uppercase;
        }

        .lv-product__name {
            text-transform: none;
        }

        .heading-s {
            font-size: 1.125rem;
            letter-spacing: .025rem;
            line-height: 1.5rem;
            font-weight: 400;
        }


        .variation-selector__title {
            font-size: .875rem;
            letter-spacing: .025rem;
            line-height: 1rem;
            font-weight: 400;
            color: inherit;
        }

        .variation-selector__value {
            font-size: .875rem;
            letter-spacing: .025rem;
            line-height: 1rem;
            font-weight: 400;
            color: inherit;
        }

        h1, h2, h3, h4, h5, h6 {
            font-weight: 400;
        }

        h1 {
            font-size: 2em;
        }
    </style>
</head>
<body>
<c:import url="navbar.jsp"></c:import>
<div class="my-5">
    <div class="container">
        <div class="d-flex align-items-center align-content-center">
            <p class="p-0 "><a href="/products" class=" m-0 text-black text-decoration-none">Trang chủ</a>></p>
            <p class=" p-0 align-items-center align-content-center h-100">Chi tiết sản phẩm</p>
        </div>
        <hr>
        <div class="row">
            <div class="col-6 ">
                <div class="card ">
                    <div class="card row justify-content-center" style="background: rgb(246,245,243)">
                        <div class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <c:forEach var="image" items="${productAdminDetailDTO.image}">
                                    <div class="carousel-item active">
                                        <img src="${image}"
                                             class="d-block w-100" alt="...">
                                    </div>
                                </c:forEach>
                            </div>
                            <button class="carousel-control-prev" type="button"
                                    data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button"
                                    data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="col-lg-7 ">
                    <div class="container  offset-6">
                        <strong class="overline">
                            ${productAdminDetailDTO.productCode}
                        </strong>
                        <h1 class="lv-product__name heading-s">
                            ${productAdminDetailDTO.productName}
                        </h1>
                        <span> ${productAdminDetailDTO.price}</span>
                        <span class="variation-selector__title">Chất liệu</span>
                        <span class="variation-selector__value">
                            ${productAdminDetailDTO.material}
                        </span>
                        <hr>
                        <span class="variation-selector__title">Kích thước</span>
                        <div class="btn-group dropend">
                            <button type="button" class="btn ">
                                ${productAdminDetailDTO.size}
                            </button>
                            <%--                            <button type="button" class="btn  dropdown-toggle dropdown-toggle-split"--%>
                            <%--                                    data-bs-toggle="dropdown" aria-expanded="false">--%>
                            <%--                                <span class="visually-hidden">Toggle Dropright</span>--%>
                            <%--                            </button>--%>
                        </div>
                        <br>
                        <span class="variation-selector__title">Số lượng</span>
                        <div class="btn-group dropend">
                            <div class="form-outline my-1" style="width: 5rem;">
                                <input value="1" type="number" id="typeNumber" class="form-control"/>
                            </div>
                        </div>

                        <div class="d-grid gap-2">
                            <a href="/products?action=create-product-order&id=${productAdminDetailDTO.productCode}">
                                <button class="btn btn-outline-secondary">Thêm vào giỏ hàng</button>
                            </a>
                        </div>
                        <br>
                        <div>
                            <p class="overline">Kiểm tra tình trạng còn hàng tại cửa hàng
                            </p>
                            <p style="padding: 0px" class="overline">
                                Thông tin chi tiết sản phẩm
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
