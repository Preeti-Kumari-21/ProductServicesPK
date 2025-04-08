package com.scaler.productservicespk.services;

import com.scaler.productservicespk.dtos.FakeStoreProductsDto;
import com.scaler.productservicespk.exceptions.ProductNotFoundException;
import com.scaler.productservicespk.models.Category;
import com.scaler.productservicespk.models.Product;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {

       //throw new RuntimeException("Something went wrong");
        throw new ProductNotFoundException("Product not found");

//        FakeStoreProductsDto fakeStoreProductsDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/"+productId,
//                FakeStoreProductsDto.class);
//
//        // convert FakeStoreProductsDto to Product object as the function returns Product
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductsDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductsDto[] fakeStoreProductsDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductsDto[].class
        );

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductsDto fakeStoreProductsDto : fakeStoreProductsDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductsDto));

        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void updateProduct(Long productId, Product product) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductsDto fakeStoreProductsDto){
        Product product = new Product();

        product.setId(fakeStoreProductsDto.getId());
        product.setTitle(fakeStoreProductsDto.getTitle());
        product.setPrice(fakeStoreProductsDto.getPrice());
        product.setDescription(fakeStoreProductsDto.getDescription());

        product.setCategory(new Category());
        product.getCategory().setValue(fakeStoreProductsDto.getCategory());

        return product;
    }
}
