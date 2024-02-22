package com.nimap.springapplication.service.impl;

import com.nimap.springapplication.exception.ResourceNotFoundException;
import com.nimap.springapplication.model.Category;
import com.nimap.springapplication.repository.CategoryRepository;
import com.nimap.springapplication.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        Optional<Category> category=categoryRepository.findById(id);

        if(category.isPresent()){
            return category.get();
        }else {
            throw new ResourceNotFoundException("Category", "Id", id);
        }

    }
    @Override
    public Category updateCategory(Category category, long id) {

        // Check if the category with the given id exists in the database
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));

        // Update the properties of the existing category with the values from the provided category
        existingCategory.setName(category.getName());

        // Add more properties as needed

        // Save the updated category back to the database
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        //check whether a category in db or not
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
        categoryRepository.deleteById(id);
    }

}
