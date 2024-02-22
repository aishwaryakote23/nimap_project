package com.nimap.springapplication.service;

import com.nimap.springapplication.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

// Service interface for managing Product entities
public interface ProductService {

    // Save a new product to the database
    Product saveProduct(Product product);

    // Retrieve all products with pagination from the database
    Page<Product> getAllProducts(PageRequest pageRequest);

    // Retrieve a product by its unique identifier
    Product getProductById(long id);

    // Update an existing product in the database
    Product updateProduct(Product product, long id);

    // Delete a product from the database by its unique identifier
    void deleteProduct(long id);
}
