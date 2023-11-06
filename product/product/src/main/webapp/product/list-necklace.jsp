<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/4/2023
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dây chuyền</title>
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

        h1:not([class*=is-title-]), .is-title-xxl {
            font-size: 2.5rem;
            font-weight: 100;
            letter-spacing: -0.05em;
            line-height: 2.5rem;
            text-transform: uppercase;
        }

        .card {
            border: none;
        }

        .cc-announcement {
            background-color: rgb(255, 255, 255);
            color: rgb(255, 255, 255);
            position: relative;
            text-align: center;
            transition: max-height 1s, opacity 0.5s, visibility 0.5s;
        }

        a:-webkit-any-link {
            color: -webkit-link;
            cursor: pointer;
            text-decoration: underline;
        }

        a {
            text-decoration: none !important;
            /*color: inherit;*/
            -webkit-transition: color 150ms, background-color 150ms;
            -ms-transition: color 150ms, background-color 150ms;
            -moz-transition: color 150ms, background-color 150ms;
            -o-transition: color 150ms, background-color 150ms;
            transition: color 150ms, background-color 150ms;
            color: black;
        }

        @media (min-width: 1400px) {
            .site-control.nav-inline-desktop .nav-right-side {
                width: 270px;
            }
        }

        @media (min-width: 1441px) {
            .site-control.nav-inline-desktop .nav-row .nav-columns {
                padding-left: 90px;
                padding-right: 90px;
            }
        }

        .color-text {
            color: black;
        }

        video {
            width: 100%;
        }

        lifestyle-video {
            height: auto;
        }

        .h1-hover:hover {
            color: red;
        }

        a {
            text-decoration: none;
        }

        div {
            font-family: 'Roboto', sans-serif;
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

        h1:not([class*=is-title-]), .is-title-xxl {
            font-size: 2.5rem;
            font-weight: 100;
            letter-spacing: -0.05em;
            line-height: 2.5rem;
            text-transform: uppercase;
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <c:import url="navbar.jsp"></c:import>
    <div>
        <main>
            <div class="d-flex align-items-center position-relative">
                <img src="https://puls-img.chanel.com/c_limit,w_2800/q_auto:good,f_auto,dpr_1.1/1692625767552-visueljpg_4320x5760.jpg"
                     style="height: 100%;width: 100%">
                <div class="container position-absolute col-4 col-md-6 offset-4">
                    <h1 style="color: white">Thời Trang & Phong Cách</h1>
                </div>
            </div>
            <div>
                <div class="container mt-1">
                    <div class="row justify-content-center">
                        <div class="col-3"></div>
                        <div class="col-5">
                            <h1>All for One </h1>
                            <p style="font-size: 0.8rem;font-family: Cantarell">
                                Đeo các thiết kế nhẫn COCO CRUSH nhiều kích cỡ với chất liệu vàng khác nhau, đính hoặc
                                không
                                đính kim cương trên cùng một ngón tay.
                            </p>
                        </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </div>
            <div class="d-flex align-items-center position-relative">
                <img src="https://puls-img.chanel.com/c_limit,w_2800/q_auto:good,f_auto,dpr_1.1/1692627310752-visueljpg_4320x5760.jpg"
                     style="height: 100%;width: 100%">
                <div class="container position-absolute col-4 col-md-6 offset-1">
                </div>
                <div class="container position-absolute col-4 col-md-6 offset-4">

                    <h1 style="color: white">Khẳng định lại vị thế của </h1>
                    <h1 style="color: white"> bản thân </h1>
                </div>
            </div>
            <div class="container mt-5">
                <h3 class="h1-hover">TẤT CẢ SẢN PHẨM DÂY CHUYẾN</h3>
                <tbody>
                <table class="table table-hover" id="example">
                    <tbody>
                    <tr class="row">
                        <c:forEach items="${productNecklaceDTOList}" var="product">
                            <td class="col-lg-3 col-md-6">
                                <div class="card ">
                                    <div class="card row justify-content-center">
                                        <div class="carousel slide" data-bs-ride="carousel"
                                             style="background: rgb(246,245,243)">
                                            <div class="carousel-inner">
                                                <c:forEach items="${product.image}" var="image" varStatus="loop">
                                                    <c:if test="${loop.index==0}">
                                                        <div class="carousel-item active">
                                                            <img src="${image}"
                                                                 class="d-block w-100" alt="...">
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${loop.index!=0}">
                                                        <div class="carousel-item">
                                                            <img src="${image}"
                                                                 class="d-block w-100" alt="...">
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <button class="carousel-control-prev" type="button"
                                                    data-bs-target="#carouselExampleAutoplaying"
                                                    data-bs-slide="prev">
                                                        <span class="carousel-control-prev-icon"
                                                              aria-hidden="true"></span>
                                                <span class="visually-hidden">Previous</span>
                                            </button>
                                            <button class="carousel-control-next" type="button"
                                                    data-bs-target="#carouselExampleAutoplaying"
                                                    data-bs-slide="next">
                                                        <span class="carousel-control-next-icon"
                                                              aria-hidden="true"></span>
                                                <span class="visually-hidden">Next</span>
                                            </button>
                                            <div class="card-body">
                                                <a href="/products?action=detail&id=${product.productCode}" class="text-black">
                                                    <h5 class="card-title">${product.productName}</h5></a>
<%--                                                <h5 class="card-title">${product.productName}</h5>--%>
                                                <p class="card-text">${product.material}</p>
                                                <p class="card-text">${product.gia}</p>
                                                <button class="btn btn-outline-secondary">Mua ngay</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
                </tbody>
            </div>
        </main>
    </div>
    <c:import url="footer.jsp"></c:import>
</div>
</body>
</html>
