package com.nimap.springapplication.repository;

import com.nimap.springapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// JpaRepository provides CRUD operations for the Product entity
// PagingAndSortingRepository extends JpaRepository with additional paging and sorting capabilities
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {

}
