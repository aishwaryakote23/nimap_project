package com.nimap.springapplication.service;

import com.nimap.springapplication.model.Category;

import java.util.List;

// Service interface for managing Category entities
public interface CategoryService {

    // Save a new category to the database
    Category saveCategory(Category category);

    // Retrieve all categories from the database
    List<Category> getAllCategories();

    // Retrieve a category by its unique identifier
    Category getCategoryById(long id);

    // Update an existing category in the database
    Category updateCategory(Category category, long id);

    // Delete a category from the database by its unique identifier
    void deleteCategory(long id);
}
