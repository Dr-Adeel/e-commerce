package com.eilco.e_commerce.repository;

import com.eilco.e_commerce.model.entities.Category;
import com.eilco.e_commerce.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
