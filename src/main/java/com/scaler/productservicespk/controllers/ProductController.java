package com.scaler.productservicespk.controllers;

import com.scaler.productservicespk.models.Product;
import com.scaler.productservicespk.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //http://localhost:8080/products/1 => Get a single product with id 1
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }

    //http://localhost:8080/products => Get all the products
    @GetMapping
    public List<Product> getAllProduct(){
        return new ArrayList<>();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    //http://localhost:8080/products/1
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){

    }

    //http://localhost:8080/products/1 => Partial update of the products so Patch mapping
    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long productId, @RequestBody Product product){

    }

    //http://localhost:8080/products/1 => Complete update of the product so PUT mapping
    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){

    }


}
