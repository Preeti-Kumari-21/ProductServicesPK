package com.scaler.productservicespk;

import com.scaler.productservicespk.repositories.ProductRepository;
import com.scaler.productservicespk.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServicesPkApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery(){
        ProductWithTitleAndPrice productWithTitleAndPrice = productRepository.getTitleAndPriceById(1L);
        System.out.println(productWithTitleAndPrice.getPrice());
        System.out.println(productWithTitleAndPrice.getTitle());
    }

}
