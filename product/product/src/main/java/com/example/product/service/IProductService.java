package com.example.product.service;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Material;
import com.example.product.model.OrderCartDTO;
import com.example.product.model.ProductSize;
import com.example.product.model.ProductType;

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

}
