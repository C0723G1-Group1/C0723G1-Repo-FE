package com.example.product.controller;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.*;
import com.example.product.service.IAccountService;
import com.example.product.service.IProductService;
import com.example.product.service.impl.AccountService;
import com.example.product.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private IAccountService accountService = new AccountService();

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
                HttpSession session = request.getSession();
                String user = (String) session.getAttribute("account");
                if (accountService.getAccType(user) == 2) {
                    listProductAdmin(request, response);
                } else {
                    userHome(request, response);
                }
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "login":
                loginAccount(request, response);
                break;
            case "logout":
                logoutAcc(request, response);
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
            case "create-product":
                createProduct(request, response);
                break;
            case "delete-product":
                deleteProduct(request, response);
                break;
            case "create-product-order":
                createProductOrder(request, response);
                break;
            case "list-order-cart":
                showOrderCard(request, response);
                break;
            case "delete-cart":
                deleteCart(request, response);
            default:
                HttpSession session1 = request.getSession();
                if (session1.getAttribute("account") == null) {
                    session1.setAttribute("account", "");
                }
                listProduct(request, response);
                break;
        }
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteOrderCart(id);
        showOrderCard(request, response);
    }

    private void showOrderCard(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("account");
        List<OrderCartDTO> orderCartDTOList = productService.displayAllOrderCard(user);
        List<OrderCart> orderCartList = productService.displayAllOrderCardByUser(user);
        request.setAttribute("orderCartDTOList", orderCartDTOList);
        request.setAttribute("orderCartList", orderCartList);
        CustomerDTO customerDTO = productService.getCustomerByUser(user);
        request.setAttribute("customerDTO", customerDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/order-cart.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void logoutAcc(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("account", "");
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void userHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/customer-order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProductOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("account");
        if (!user.equals("")) {
            String productCode = request.getParameter("id");
            int idProduct = productService.getIdByCode(productCode);
            int idAccount = productService.getIdAccountByUser(user);
            OrderCart orderCart = new OrderCart(idAccount, idProduct, 1);
            productService.insertOrderCard(orderCart);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                response.sendRedirect("product/login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("id");
        productService.deleteProduct(productCode);
        try {
            response.sendRedirect("products?action=list-product-admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Material> materialList = productService.displayAllMaterial();
        List<ProductType> productTypeList = productService.displayAllProductType();
        List<ProductSize> productSizeList = productService.displayAllProductSize();
        request.setAttribute("materialList", materialList);
        request.setAttribute("productTypeList", productTypeList);
        request.setAttribute("productSizeList", productSizeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            case "create-product":
                insertProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "check-exist":
                checkExist(request, response);
                break;
            case "create-order":
                createOrder(request, response);
                break;
            case "register":
                register(request, response);
                break;
        }
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("account");
        int idAccount = productService.getIdAccountByUser(user);
        String name = request.getParameter("name");
        String address = request.getParameter("street-name");
        ;
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        LocalDate date = LocalDate.now();
        String dateStr = String.valueOf(date);
        String transfer = "Chờ xác nhận";
        int payCode = 1;
        Random random = new Random();
        String orderCode = "DH" + random.nextInt(10000);
        Order order = new Order(orderCode, idAccount, name, phone, address, email, dateStr, transfer, payCode);
        productService.insertOrder(order);
        String orderDetailCode;
        int idOrder = productService.getIdByOrderCode(orderCode);
        int idProduct;
        int price;
        int quantity;
        List<OrderCartDTO> orderCartDTOList = productService.displayAllOrderCard(user);
        int index = 0;
        for (OrderCartDTO orderCartDTO : orderCartDTOList) {
            orderDetailCode = "ABC" + random.nextInt(10000);
            idProduct = productService.getIdByCode(orderCartDTO.getProductCode());
            price = orderCartDTO.getProvisional() / orderCartDTO.getQuantity();
            quantity = Integer.parseInt(request.getParameter("quantity-" + index));
            index++;
            OrderDetail orderDetail = new OrderDetail(orderDetailCode, idOrder, idProduct, price, quantity);
            productService.insertOrderDetail(orderDetail);
        }
        List<OrderCart> orderCartList = productService.displayAllOrderCardByUser(user);
        for (OrderCart orderCart : orderCartList) {
            productService.deleteOrderCart(orderCart.getId());
        }
        try {
            response.sendRedirect("products?action=list-order-cart");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accountService.isUsernameExist(username)) {
            try {
                response.sendRedirect("product/login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            accountService.addNewUserPassword(username, password);
            int idAcc = accountService.getIdAccount(username);
            String cusCode = "KH-0000" + idAcc;
            String cusName = request.getParameter("hoten");
            String mail = request.getParameter("mail");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            accountService.addNewCustomer(cusCode, cusName, mail, phone, address, gender, idAcc);
            try {
                response.sendRedirect("product/login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkExist(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("account");
        String password = request.getParameter("password");
        boolean check = accountService.checkAccount(username, password);
        if (check) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("account", username);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            loginAccount(request, response);
        }

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");
        String material = request.getParameter("material");
        String describe = request.getParameter("describe");
        String sizeProduct = request.getParameter("size-product");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        String[] imageArray = image.split(",");
        List<String> imageList = new ArrayList<>();
        for (String str : imageArray) {
            imageList.add(str);
        }
        ProductAdminDTO productAdminDTO = new ProductAdminDTO(productCode, productName, material, productType, sizeProduct, quantity, price, imageList, describe);
        productService.insertProductAdminDTO(productAdminDTO);
        try {
            response.sendRedirect("products?action=list-product-admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
