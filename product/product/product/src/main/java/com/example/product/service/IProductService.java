package com.example.product.service;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.*;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAllProductRingHome();
    List<ProductDTO> findAllProductNecklaceHome();
    List<ProductDTO> findAllProductOutstandingHome();
    List<ProductDTO> findAllProductRing();
    List<ProductDTO> findAllProductNecklace();
    List<ProductDTO> findAllProductGold();
    List<ProductDTO> findAllProductSilver();
    List<ProductAdminDTO> findAllProductAdmin();
    boolean updateProduct(ProductAdminDTO productAdminDTO);
    ProductAdminDTO selectProductAdminDTO(String id);
    List<Material> displayAllMaterial();
    List<ProductType> displayAllProductType();
    List<ProductSize> displayAllProductSize();
    int getIdByCode(String code);
    void insertProductAdminDTO(ProductAdminDTO productAdminDTO);
    boolean deleteProduct(String productCode);
    List<OrderCartDTO> displayAllOrderCard(String user);
    void insertOrderCard(OrderCart orderCart);
    int getIdAccountByUser(String user);
    List<OrderCart> displayAllOrderCardByUser(String user);
    boolean deleteOrderCart(int id);
    CustomerDTO getCustomerByUser(String user);
    void insertOrder(Order order);

    void insertOrderDetail(OrderDetail orderDetail);
    int getIdByOrderCode(String orderCode);

}
