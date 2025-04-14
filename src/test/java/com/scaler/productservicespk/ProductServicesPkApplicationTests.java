package com.scaler.productservicespk;

import com.scaler.productservicespk.repositories.CategoryRepository;
import com.scaler.productservicespk.repositories.ProductRepository;
import com.scaler.productservicespk.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void testQuery2(){
        categoryRepository.deleteById(7L);
    }

}
