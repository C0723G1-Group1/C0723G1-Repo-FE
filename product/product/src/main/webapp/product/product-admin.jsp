<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/4/2023
  Time: 3:08 PM
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

        title-h2 {
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

        .btn-outline-danger {
            font-size: 12px;

        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
</head>
<body>
<div>
    <c:import url="navbar.jsp"></c:import>
    <div class="row m-4">
        <c:import url="menu-admin.jsp"></c:import>
        <div class="col-md-10 col-sm-12">
            <h2 class="title-h2">Quản lý sản phẩm</h2>
            <form>
                <div class="row b1">
                    <div class="col-md-2 col-sm-6">
                        <p>Mã đơn hàng</p>
                        <input class="form-control form-control-sm b1" type="text" placeholder="Example"
                               aria-label=".form-control-sm example">
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <p>Chất liệu</p>
                        <select class="form-select form-select-sm b1" aria-label="Small select example">
                            <option selected>Tất cả</option>
                            <option value="1">Vàng</option>
                            <option value="1">Bạc</option>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <p>Sắp xếp theo giá</p>
                        <select class="form-select form-select-sm b1" aria-label="Small select example">
                            <option selected>Giá tăng dần</option>
                            <option value="1">Giá giảm dần</option>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <p>Loại sản phẩm</p>
                        <select class="form-select form-select-sm b1" aria-label="Small select example">
                            <option selected>Tất cả</option>
                            <option value="1">Nhẫn</option>
                            <option value="1">Bông tai</option>
                            <option value="1">Vòng tay</option>
                            <option value="1">Dây chuyền</option>
                            <option value="1">Lắc tay</option>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <p>Size sản phẩm</p>
                        <select class="form-select form-select-sm b1" aria-label="Small select example">
                            <option selected>Tất cả</option>
                            <option value="1">1</option>
                            <option value="1">2</option>
                            <option value="1">3</option>
                            <option value="1">4</option>
                            <option value="1">5</option>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <div class="py-4" style="position: relative ; top: 10px;">
                            <button type="submit" class="btn btn-outline-danger bt b1" style="height: 30.33px">Tìm
                                kiếm
                            </button>
                            <button type="submit" class="btn btn-outline-danger bt b1" style="height: 30.33px">Thêm sản
                                phẩm
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <div class="b1">
                <table class="table table-striped table-hover " id="example">
                    <thead style="font-size: 14px">
                    <tr class="table-primary">
                        <th>Mã đơn hàng</th>
                        <th>Tên sản phẩm</th>
                        <th>Chất liệu sản phẩm</th>
                        <th>Loại sản phẩm</th>
                        <th>Size sản phẩm</th>
<%--                        <th>Số lượng sản phẩm</th>--%>
                        <th>Giá sản phẩm</th>
<%--                        <th>Ảnh</th>--%>
<%--                        <th>Mô tả</th>--%>
                        <th>Chi tiết</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productAdminDTOList}">
                        <div>
                            <tr>
                                <td>${product.productCode}</td>
                                <td>${product.productName}</td>
                                <td>${product.material}</td>
                                <td>${product.productType}</td>
                                <td>${product.size}</td>
<%--                                <td>${product.quantity}</td>--%>
                                <td>${product.price}</td>
<%--                                <td class="d-flex justify-content-center">--%>
<%--                                    <c:forEach var="image" items="${product.image}">--%>
<%--                                        <img src="${image}" style="width: 100px; height: 100px">--%>
<%--                                    </c:forEach>--%>
<%--                                </td>--%>
<%--                                <td>${product.describe}</td>--%>
                                <td>
                                    <a href="/products?action=detail-admin&id=${product.productCode}">
                                    <button type="button" class="btn btn-outline-primary" style="font-size: 16px;">Chi tiết
                                    </button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/products?action=edit&id=${product.productCode}">
                                        <button type="button" class="btn btn-outline-danger bt b1" style="font-size: 16px;">
                                            sửa
                                        </button>
                                    </a>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-danger bt b1" style="font-size: 16px;">
                                        Xóa
                                    </button>
                                </td>
                            </tr>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:import url="footer.jsp"></c:import>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js" ></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js" ></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js" ></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js" ></script>
<script>
    new DataTable('#example',{
        order: [[5, 'desc']],
        paging: true
    });
</script>
</body>
</html>
