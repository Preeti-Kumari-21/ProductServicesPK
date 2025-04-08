package com.scaler.productservicespk.services;

import com.scaler.productservicespk.exceptions.ProductNotFoundException;
import com.scaler.productservicespk.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteProduct(Long productId);

    void updateProduct(Long productId, Product product);

    void replaceProduct(Long productId, Product product);
}
