package com.nimap.springapplication.repository;

import com.nimap.springapplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository provides CRUD operations for the Category entity
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
