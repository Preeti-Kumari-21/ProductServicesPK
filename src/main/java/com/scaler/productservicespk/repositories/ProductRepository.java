package com.scaler.productservicespk.repositories;

import com.scaler.productservicespk.models.Product;
import com.scaler.productservicespk.repositories.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);
    //This method will generate the sql query as
    // select * from products where id = 1
    //Here the above query can return NULL if product with given id is not present in the table.
    //Thus the return type of this function is Optional<Product> as Optional will request compiler to ask
    // //user to do specific check for NULL


    @Override
    List<Product> findAll();
    //This will return the result of below query
    //select * from products.
    //Here findAll() method doesn't return Optional<List<Product>> because "select * from products" query
    //even when empty will not return NULL rather return an empty List object.


    @Override
    Product save(Product product);

    @Query("select p.title as title,p.price price from products p where p.id = :id")
    ProductWithTitleAndPrice getTitleAndPriceById(@Param("id") Long id);

    @Query("select p.title as title,p.price price from products p")
    List<ProductWithTitleAndPrice> getListOfTitleAndPriceById(@Param("id") Long id);
}