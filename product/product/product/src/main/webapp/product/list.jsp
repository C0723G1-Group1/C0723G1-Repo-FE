<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/3/2023
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
    <style>
        .h1-hover:hover {
            color: red;
        }

        a {
            text-decoration: none;
        }

        div {
            font-family: 'Roboto', sans-serif;
        }

        card {
            border: none;
        }
        .text-overflow {
            white-space: nowrap;
            width: 100%;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
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
        <main style="background: rgb(246,245,243)">
            <div class="d-flex align-items-center position-relative">
                <video autoplay muted loop>
                    <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/1aqs4xOgY1_HD.mp4"
                            type="video/mp4">
                </video>
                <div class="container position-absolute col-4 col-md-6 offset-1">
                    <h1 style="color: white">Luna Brother
                    </h1>
                    <br>
                    <h2 style="color: white">Bộ sưu tập trang sức cao cấp</h2>
                    <a href="#about" class="" style="color: white">Khám phá ngay</a>
                </div>
            </div>
            <div class="container mt-5">
                <h3 class="h1-hover">SẢN PHẨM NỔI BẬT</h3>
                <tbody>
                <table class="table table-hover" id="example">
                    <tbody>
                    <tr class="row">
                        <c:forEach items="${productOutstandingHomeDTOList}" var="product">
                            <td class="col-lg-3 col-sm-6 col-xs-12">
                                <div class="card " style="border: none">
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
                                                <a href="/products?action=detail&id=${product.productCode}"
                                                   class="text-black">
                                                    <h5 class="card-title text-overflow">${product.productName}</h5></a>
                                                <p class="card-text">${product.material}</p>
                                                <p class="card-text">${product.gia}</p>
                                                <div class="d-lex justify-content-between">
                                                    <a href="/products?action=create-product-order&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary">Thêm vào giỏ hàng</button>
                                                    </a>
                                                    <a href="/products?action=detail&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary mx-3">Chi tiết</button>
                                                    </a>
                                                </div>
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
            <div class="d-flex align-items-center position-relative mt-0">

                <video autoplay muted loop>
                    <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/SvZrU6krHZ_HD.mp4"
                            type="video/mp4">
                </video>
                <div class="container position-absolute col-4 col-md-6 offset-1" data-aos="fade-up"
                     data-aos-delay="500">
                    <h1 style="color: white">Trang sức </h1>
                    <h2 style="color: white"> là thứ không thể thiếu</h2>
                    <a href="#about" class="" style="color: white">Mua ngay thôi</a>
                </div>
            </div>
            <div class="container mt-5">
                <div class="d-flex justify-content-between flex-wrap">
                    <h3 class="h1-hover">TRANG SỨC DÂY CHUYỀN</h3>
                    <a href="products?action=list-necklace" class="text-black"><h5 class="h1-hover">Xem tất cả</h5></a>
                </div>
                <tbody>
                <table class="table table-hover" id="example1">
                    <tbody>
                    <tr class="row">
                        <c:forEach items="${productNecklaceHomeDTOList}" var="product">
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
                                                <a href="/products?action=detail&id=${product.productCode}"
                                                   class="text-black">
                                                    <h5 class="card-title text-overflow">${product.productName}</h5></a>
                                                    <%--                                                <h5 class="card-title">${product.productName}</h5>--%>
                                                <p class="card-text">${product.material}</p>
                                                <p class="card-text">${product.gia}</p>
                                                <div class="d-lex justify-content-between">
                                                    <a href="/products?action=create-product-order&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary">Thêm vào giỏ hàng</button>
                                                    </a>
                                                    <a href="/products?action=detail&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary mx-2">Chi tiết</button>
                                                    </a>
                                                </div>
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
            <div class="d-flex align-items-center position-relative">

                <video autoplay muted loop>
                    <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/ewLfG7Uewj_HD.mp4"
                            type="video/mp4">
                </video>
                <div class="container position-absolute col-4 col-md-6 offset-1" data-aos="fade-up"
                     data-aos-delay="500">
                    <h1 style="color: white">Hãy để chúng tôi </h1>
                    <h2 style="color: white"> hiểu bạn hơn</h2>
                </div>
            </div>
            <div class="container mt-5">
                <div class="d-flex justify-content-between flex-wrap">
                    <h3 class="h1-hover">TRANG SỨC NHẪN</h3>
                    <a href="products?action=list-ring" class="text-black"><h5 class="h1-hover">Xem tất cả</h5></a>
                </div>
                <tbody>
                <table class="table table-hover" id="example2">
                    <tbody>
                    <tr class="row">
                        <c:forEach items="${productRingHomeDTOList}" var="product">
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
                                            <div class="card-body row">
                                                <a href="/products?action=detail&id=${product.productCode}"
                                                   class="text-black">
                                                    <h5 class="card-title text-overflow">${product.productName}</h5></a>
                                                    <%--                                                <h5 class="card-title">${product.productName}</h5>--%>
                                                <p class="card-text">${product.material}</p>
                                                <p class="card-text">${product.gia}</p>
                                                <div class="d-lex justify-content-between">
                                                    <a href="/products?action=create-product-order&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary">Thêm vào giỏ hàng</button>
                                                    </a>
                                                    <a href="/products?action=detail&id=${product.productCode}">
                                                        <button class="btn btn-outline-secondary mx-2">Chi tiết</button>
                                                    </a>
                                                </div>
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
            <div class="container ">
                <div class="row">
                    <h3> Ưu đãi độc quyền </h3>
                    <div id="carouselExampleDark" class="carousel carousel-dark slide mt-3">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0"
                                    class="active"
                                    aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                                    aria-label="Slide 2"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active"
                                 data-bs-interval="10000">
                                <div class="img">
                                    <img src="https://cdn.pnj.io/images/thumbnails/485/485/detailed/141/gn0000y000203-nhan-kim-tien-vang-y-18k-pnj-1__2_.png"
                                         class="h-auto blur-up "
                                         alt=""
                                         style="width: 200px"
                                    >
                                </div>
                                <div class="carousel-caption d-md-block">
                                    <h5>TRANG SỨC VÀNG ƯU ĐÃI ĐẾN 15%</h5>
                                    <p>
                                        Nhân dịp khai trương chi nhánh mới, hệ thống cửa hàng trang sức vàng trên toàn
                                        quốc
                                        đồng loạt giảm giá 15% cho tất cả các sản phẩm. Chương trình áp dụng từ ngày
                                        20/7
                                        đến ngày 31/7/2023.
                                    </p>
                                </div>
                            </div>
                            <div class="carousel-item"
                                 data-bs-interval="2000">
                                <div class="img">
                                    <img src="https://cdn.pnj.io/images/thumbnails/300/300/detailed/184/sp-gmddddw001894-mat-day-chuyen-kim-cuong-vang-trang-14k-pnj-1.png "
                                         class="h-auto blur-up lazypreload lazyloaded"
                                         alt="Surface Laptop Studio 2 Consumer Bundle"
                                         style="width: 200px"
                                    >
                                </div>
                                <div class="carousel-caption d-md-block">
                                    <h5>
                                        TRANG SỨC BẠC ƯU ĐÃI ĐẾN 25%</h5>
                                    <p>Từ ngày 20/7 đến ngày 31/7/2023, hệ thống cửa hàng trang sức bạc trên toàn quốc
                                        đồng
                                        loạt giảm giá 25% cho tất cả các sản phẩm. Đây là cơ hội tuyệt vời để bạn sở hữu
                                        những món trang sức bạc đẹp mắt và chất lượng với giá ưu đãi.</p>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                                data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                                data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>

        </main>
    </div>
    <c:import url="footer.jsp"></c:import>
</div>
</body>
</html>
