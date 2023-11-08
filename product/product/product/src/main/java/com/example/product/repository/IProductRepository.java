package com.example.product.repository;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.*;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> findAllProductRingHome();

    List<ProductDTO> findAllProductNecklaceHome();

    List<ProductDTO> findAllProductRing();

    List<ProductDTO> findAllProductNecklace();

    List<ProductDTO> findAllProductOutstandingHome();

    List<ProductDTO> findAllProductGold();

    List<ProductDTO> findAllProductSilver();

    List<ProductAdminDTO> findAllProductAdmin();

    boolean updateProduct(ProductAdminDTO productAdminDTO);

    ProductAdminDTO selectProductAdminDTO(String id);

    List<Material> displayAllMaterial();

    List<ProductType> displayAllProductType();

    List<ProductSize> displayAllProductSize();

    int getIdByCode(String code);

    int getIdImage(String linkPath, int id);

    void insertProductAdminDTO(ProductAdminDTO productAdminDTO);

    boolean deleteProduct(String productCode);

    void insertOrderCard(OrderCart orderCart);

    List<OrderCartDTO> displayAllOrderCard(String user);

    int getIdAccountByUser(String user);

    boolean deleteOrderCart(int id);

    List<OrderCart> displayAllOrderCardByUser(String user);

    CustomerDTO getCustomerByUser(String user);

    void insertOrder(Order order);

    void insertOrderDetail(OrderDetail orderDetail);

    int getIdByOrderCode(String orderCode);
}
