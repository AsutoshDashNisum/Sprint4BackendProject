package com.product_service.service.impl;

import com.product_service.model.Product;
import com.product_service.repository.ProductRepository;
import com.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    // ✅ UPDATE by SKU
    @Override
    public Product updateProductBySku(String sku, Product updatedProduct) {
        Product existingProduct = repository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product with SKU " + sku + " not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCategoryName(updatedProduct.getCategoryName());
        existingProduct.setSize(updatedProduct.getSize());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDiscount(updatedProduct.getDiscount());
        existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());

        // Only set SKU if you want to allow changing it (usually not recommended)
        // existingProduct.setSku(updatedProduct.getSku());

        return repository.save(existingProduct);
    }

    // ✅ DELETE by SKU
    @Override
    public void deleteProductBySku(String sku) {
        Product existingProduct = repository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product with SKU " + sku + " does not exist"));
        repository.delete(existingProduct);
    }
}
