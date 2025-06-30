package com.product_service.controller;

import com.product_service.model.Product;
import com.product_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.saveProduct(product));
    }

    // ✅ UPDATE by SKU
    @PutMapping("/sku/{sku}")
    public ResponseEntity<Product> updateProductBySku(@PathVariable String sku, @RequestBody Product updatedProduct) {
        Product product = service.updateProductBySku(sku, updatedProduct);
        return ResponseEntity.ok(product);
    }

    // ✅ DELETE by SKU
    @DeleteMapping("/sku/{sku}")
    public ResponseEntity<Void> deleteProductBySku(@PathVariable String sku) {
        service.deleteProductBySku(sku);
        return ResponseEntity.noContent().build();
    }
}
