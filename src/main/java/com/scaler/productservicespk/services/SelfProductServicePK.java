package com.scaler.productservicespk.services;

import com.scaler.productservicespk.exceptions.ProductNotFoundException;
import com.scaler.productservicespk.models.Category;
import com.scaler.productservicespk.models.Product;
import com.scaler.productservicespk.repositories.CategoryRepository;
import com.scaler.productservicespk.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductServicePK")
//@Primary
public class SelfProductServicePK implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductServicePK(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getCategory() != null){
            if(product.getCategory().getId() == null){
                //Create category first because in the POST body if user has not specified category id it means it is a new category.
                Category category = product.getCategory();

                //Now fetch the category value first from the product API sent through postman
                String categoryValue = category.getValue();

                //Now try to search in the DB if we have any category with the same value?
                Optional<Category> optionalCategory = categoryRepository.findByValue(categoryValue);

                //If the find by Value returns empty it means there is no category present in the categroy table with this category value
                //If this is the case then save the category which we are getting from postman as this is a new category.
                //Note:- We are considering that category value is going to be unique and there cannot be two category values.
                if(optionalCategory.isEmpty()){
                    category = categoryRepository.save(category);
                    product.setCategory(category);
                }
                else {

                    //If there is already a catergory present with this given category value then directly save this new product in DB by tagging it to this category.
                    //Note if there is a catergory present in DB with this category value then it surely means that that category will have category id.
                    //So now when we are saving this product to that existing category then its category id will also get added to this new product.
                    product.setCategory(optionalCategory.get());
                }


            }
        }
        else {
            throw new RuntimeException("Category cannot be empty while creating product");
        }
        return productRepository.save(product);
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
}
