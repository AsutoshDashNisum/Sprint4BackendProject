package com.product_service.service;

import com.product_service.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);

    // Removed update/delete by ID
    Product updateProductBySku(String sku, Product updatedProduct);
    void deleteProductBySku(String sku);
}
