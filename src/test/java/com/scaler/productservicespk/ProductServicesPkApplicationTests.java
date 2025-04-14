package com.scaler.productservicespk;

import com.scaler.productservicespk.models.Category;
import com.scaler.productservicespk.models.Product;
import com.scaler.productservicespk.repositories.CategoryRepository;
import com.scaler.productservicespk.repositories.ProductRepository;
import com.scaler.productservicespk.repositories.projections.ProductWithTitleAndPrice;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServicesPkApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery(){
        ProductWithTitleAndPrice productWithTitleAndPrice = productRepository.getTitleAndPriceById(1L);
        System.out.println(productWithTitleAndPrice.getPrice());
        System.out.println(productWithTitleAndPrice.getTitle());
    }

    @Test
    void testQuery1(){
        List<ProductWithTitleAndPrice> productWithTitleAndPriceList = productRepository.getListOfTitleAndPriceById(1L);
       for(ProductWithTitleAndPrice productWithTitleAndPrice : productWithTitleAndPriceList){
           System.out.println(productWithTitleAndPrice.getPrice());
           System.out.println(productWithTitleAndPrice.getTitle());
           System.out.println("------------------");

       }
    }

/*
    @Test
    void testQuery2(){
        categoryRepository.deleteById(7L);
    }
*/

    @Test
    @Transactional
    void testQuery3(){
       Optional<Category> category = categoryRepository.findById(7L);

        List<Product> products = category.get().getProducts();

        for(Product product : products){
            System.out.println(product.getTitle());
            System.out.println(product.getPrice());
            System.out.println(product.getDescription());
            System.out.println(product.getImage());
            System.out.println(product.getCategory().getName());
            System.out.println(product.getCategory().getValue());
            System.out.println("------------------");
        }

        }

}
