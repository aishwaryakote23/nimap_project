package com.nimap.springapplication.service.impl;

import com.nimap.springapplication.exception.ResourceNotFoundException;
import com.nimap.springapplication.model.Product;
import com.nimap.springapplication.repository.ProductRepository;
import com.nimap.springapplication.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Service implementation for managing Product entities
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    // Constructor to inject the ProductRepository
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Save a new product to the database
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Retrieve all products with pagination from the database
    @Override
    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    // Retrieve a product by its unique identifier
    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ResourceNotFoundException("Product", "Id", id);
        }
    }

    // Update an existing product in the database
    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());

        return productRepository.save(existingProduct);
    }

    // Delete a product from the database by its unique identifier
    @Override
    public void deleteProduct(long id) {
        productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }
}
