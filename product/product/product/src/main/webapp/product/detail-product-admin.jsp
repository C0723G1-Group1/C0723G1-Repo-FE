<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/5/2023
  Time: 7:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <c:import url="navbar.jsp"></c:import>
    <div class="row m-4">
        <c:import url="menu-admin.jsp"></c:import>
        <div class="col-md-7 col-sm-12 mx-3">
            <h2 class="title-h2">THÔNG TIN CHI TIẾT SẢN PHẨM</h2>
            <form>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Mã sản phẩm<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.productCode}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Tên sản phẩm<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.productName}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Loại sản
                        phẩm<span
                                style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.productType}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Chất liệu<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.material}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Size<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.size}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Giá<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.price}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Số lượng<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.quantity}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label" style="font-weight: bold">Mô tả<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <p>${productAdminDetailManageDTO.describe}</p>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-4" style="font-weight: bold">Ảnh<span
                            style="color: red">*</span></label>
                    <div class="col-sm-8">
                        <c:forEach var="image" items="${productAdminDetailManageDTO.image}" varStatus="loopCount">
                            <img src="${image}" style="width: 100px; height: 100px">
                        </c:forEach>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3 col-sm-12">
        </div>
    </div>
    <c:import url="footer.jsp"></c:import>
</div>
</body>
</html>
