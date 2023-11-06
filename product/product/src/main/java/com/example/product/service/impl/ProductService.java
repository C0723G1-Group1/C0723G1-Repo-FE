package com.example.product.service.impl;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Material;
import com.example.product.model.OrderCartDTO;
import com.example.product.model.ProductSize;
import com.example.product.model.ProductType;
import com.example.product.repository.IProductRepository;
import com.example.product.repository.impl.ProductRepository;
import com.example.product.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDTO> findAllProductRingHome() {
        return productRepository.findAllProductRingHome();
    }

    @Override
    public List<ProductDTO> findAllProductNecklaceHome() {
        return productRepository.findAllProductNecklaceHome();
    }

    @Override
    public List<ProductDTO> findAllProductOutstandingHome() {
        return productRepository.findAllProductOutstandingHome();
    }

    @Override
    public List<ProductDTO> findAllProductRing() {
        return productRepository.findAllProductRing();
    }

    @Override
    public List<ProductDTO> findAllProductNecklace() {
        return productRepository.findAllProductNecklace();
    }

    @Override
    public List<ProductDTO> findAllProductGold() {
        return productRepository.findAllProductGold();
    }

    @Override
    public List<ProductDTO> findAllProductSilver() {
        return productRepository.findAllProductSilver();
    }

    @Override
    public List<ProductAdminDTO> findAllProductAdmin() {
        return productRepository.findAllProductAdmin();
    }

    @Override
    public boolean updateProduct(ProductAdminDTO productAdminDTO) {
        return productRepository.updateProduct(productAdminDTO);
    }

    @Override
    public ProductAdminDTO selectProductAdminDTO(String id) {
        return productRepository.selectProductAdminDTO(id);
    }

    @Override
    public List<Material> displayAllMaterial() {
        return productRepository.displayAllMaterial();
    }

    @Override
    public List<ProductType> displayAllProductType() {
        return productRepository.displayAllProductType();
    }

    @Override
    public List<ProductSize> displayAllProductSize() {
        return productRepository.displayAllProductSize();
    }

    @Override
    public int getIdByCode(String code) {
        return productRepository.getIdByCode(code);
    }

    @Override
    public void insertProductAdminDTO(ProductAdminDTO productAdminDTO) {
        productRepository.insertProductAdminDTO(productAdminDTO);
    }

    @Override
    public boolean deleteProduct(String productCode) {
        return productRepository.deleteProduct(productCode);
    }

    @Override
    public List<OrderCartDTO> displayAllOrderCard(String user) {
        return productRepository.displayAllOrderCard(user);
    }


}
