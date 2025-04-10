package com.scaler.productservicespk.repositories;

import com.scaler.productservicespk.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
