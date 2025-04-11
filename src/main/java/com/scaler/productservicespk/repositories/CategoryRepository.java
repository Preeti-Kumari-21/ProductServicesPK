package com.scaler.productservicespk.repositories;

import com.scaler.productservicespk.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long categoryId);

    @Override
    Category save(Category category);

    Optional<Category> findByValue(String categoryValue);
}
