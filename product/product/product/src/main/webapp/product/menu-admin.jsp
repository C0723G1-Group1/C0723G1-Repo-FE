<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/3/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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


        .b1{
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
        .btn-danger{
            font-size: 12px;
            padding: 3px 3px;
        }
    </style>
</head>
<body>
<div class="col-md-2 col-sm-12 left1" style="background-color: #F5F4F4">
    <ul class="nav flex-column " >
        <li class="nav-item">
            <table >
                <tr>
                    <td><img src="https://i.imgur.com/IERUO2e.png" height="15" width="14"/></td>
                    <td><a class="nav-link text-secondary" href="#">Thông tin tài khoản</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="/products?action=get-all-order">Quản lý đơn hàng</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="#">Giỏ hàng</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="/products?action=list-product-admin">Quản lý sản phẩm</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="#">Quản lý size</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="/products?action=material-manager">Quản lý chất liệu</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="#">Quản lý loại sản phẩm</a></td>
                </tr>
            </table>
        </li>
        <li class="nav-item">
            <table>
                <tr>
                    <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                    <td><a class="nav-link text-secondary" href="#">Quản lý loại khách hàng</a></td>
                </tr>
            </table>
        </li>
    </ul>
</div>
</body>
</html>
