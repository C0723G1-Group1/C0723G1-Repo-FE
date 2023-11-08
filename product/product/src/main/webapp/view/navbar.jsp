<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/3/2023
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        .card{
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
        .color-text{
            color: black;
        }
        video {
            width: 100%;
        }
        lifestyle-video {
            height: auto;
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-white px-5">
    <div class="container-fluid p-0">
        <div>
            <a class="navbar-brand" href="/products">
                <img src="https://i.imgur.com/Gq2CtSo.jpg" height="100" width="130"/></a>
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
                        <a class="nav-link active" aria-current="page" href="/products?action=list-silver" style="color: black">
                            Trang sức bạc</a>
                    </li>
                    <li>
                        <a class="nav-link" href="/products?action=list-gold" style="color: black"> Trang sức vàng </a>
                    </li>
                    <li>
                        <a class="nav-link" href="/products?action=list-ring" style="color: black">Nhẫn</a>
                    </li>
                    <li>
                        <a class="nav-link" href="/products?action=list-necklace" style="color: black">Dây chuyền</a>
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
                <c:choose>
                    <c:when test="${account != ''}">
                        <li class="nav-item " style="margin-right: 2%">
                            <a href="/products?action=list-order-cart"><button class="btn"><i class="fa-solid fa-cart-shopping"></i></button></a>
                        </li>
                        <li>
                            <a href="/products?action=list-product-admin"><button class="btn"><i class="fa-regular fa-user"></i></button></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/products?action=login"><button class="btn"><i class="fa-solid fa-right-to-bracket"></i></button></a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${account != ''}">
                        <li>
                            <a href="/products?action=logout"><button class="btn"><i class="fa-solid fa-right-from-bracket"></i></button></a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
