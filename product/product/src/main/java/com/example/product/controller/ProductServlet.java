package com.example.product.controller;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Material;
import com.example.product.model.ProductSize;
import com.example.product.model.ProductType;
import com.example.product.service.IProductService;
import com.example.product.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "list-gold":
                listProductGold(request, response);
                break;
            case "list-silver":
                listProductSilver(request, response);
                break;
            case "list-ring":
                listProductRing(request, response);
                break;
            case "list-necklace":
                listProductNecklace(request, response);
                break;
            case "list-product-admin":
                listProductAdmin(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "login":
                loginAccount(request, response);
                break;
            case "detail":
                showDetailProduct(request, response);
                break;
            case "get-all-order":
                getAllOrder(request, response);
                break;
            case "material-manager":
                materialManager(request, response);
                break;
            case "detail-admin":
                showDetailProductAdmin(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void showDetailProductAdmin(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("id");
        ProductAdminDTO productAdminDetailManageDTO = productService.selectProductAdminDTO(code);
        request.setAttribute("productAdminDetailManageDTO", productAdminDetailManageDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/detail-product-admin.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void materialManager(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/quan_ly_chat_lieu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/user_order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("id");
        ProductAdminDTO productAdminDetailDTO = productService.selectProductAdminDTO(code);
        request.setAttribute("productAdminDetailDTO", productAdminDetailDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/detail-product.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginAccount(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/login.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                insertUser(request, response);
//                break;
            case "edit":
                updateProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String material = request.getParameter("material");
        String productType = request.getParameter("productType");
        String size = request.getParameter("size-product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
        String describe = request.getParameter("describe");
        int id = productService.getIdByCode(productCode);
        int loopCount = Integer.parseInt(request.getParameter("loopCount"));
        List<String> imageList = new ArrayList<>();
        for (int i = 1; i <= loopCount; i++) {
            imageList.add(request.getParameter("image" + i));
        }
        ProductAdminDTO productAdminDTO = new ProductAdminDTO(id, productCode, productName, material, productType, size, quantity, price, imageList, describe);
        productService.updateProduct(productAdminDTO);
        try {
            response.sendRedirect("products?action=list-product-admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        List<Material> materialList = productService.displayAllMaterial();
        List<ProductType> productTypeList = productService.displayAllProductType();
        List<ProductSize> productSizeList = productService.displayAllProductSize();
        ProductAdminDTO productEditAdminDTO = productService.selectProductAdminDTO(id);
        request.setAttribute("productEditAdminDTO", productEditAdminDTO);
        request.setAttribute("materialList", materialList);
        request.setAttribute("productTypeList", productTypeList);
        request.setAttribute("productSizeList", productSizeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProductAdmin(HttpServletRequest request, HttpServletResponse response) {
        List<ProductAdminDTO> productAdminDTOList = productService.findAllProductAdmin();
        request.setAttribute("productAdminDTOList", productAdminDTOList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/product-admin.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProductGold(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productGoldDTOList = productService.findAllProductGold();

        request.setAttribute("productGoldDTOList", productGoldDTOList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list-gold.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProductSilver(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productSilverDTOList = productService.findAllProductSilver();

        request.setAttribute("productSilverDTOList", productSilverDTOList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list-silver.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listProductNecklace(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productNecklaceDTOList = productService.findAllProductNecklace();

        request.setAttribute("productNecklaceDTOList", productNecklaceDTOList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list-necklace.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProductRing(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productRingDTOList = productService.findAllProductRing();

        request.setAttribute("productRingDTOList", productRingDTOList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list-ring.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productRingDTOList = productService.findAllProductRingHome();
        List<ProductDTO> productNecklaceDTOList = productService.findAllProductNecklaceHome();
        List<ProductDTO> productOutstandingDTOList = productService.findAllProductOutstandingHome();
        request.setAttribute("productRingHomeDTOList", productRingDTOList);
        request.setAttribute("productNecklaceHomeDTOList", productNecklaceDTOList);
        request.setAttribute("productOutstandingHomeDTOList", productOutstandingDTOList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
