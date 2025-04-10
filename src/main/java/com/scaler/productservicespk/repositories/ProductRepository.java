package com.scaler.productservicespk.repositories;

import com.scaler.productservicespk.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);
    // hibernate will create an SQL as
    //select * from products where id = id;
    
    List<Product> findAllByTitle(String title);
}