package com.nimap.springapplication.controller;

import com.nimap.springapplication.model.Category;
import com.nimap.springapplication.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    //build create category REST API
    //http://localhost:8080/api/categories
    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);

    }

    //build get all categories REST API
    //http://localhost:8080/api/categories
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    //build get category by id REST API
    //http://localhost:8080/api/categories/1
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long categoryId){
        return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);

    }

    //build update category by id REST API
    //http://localhost:8080/api/categories/1
    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id
                                             ,@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.updateCategory(category, id), HttpStatus.OK);

    }

    //build delete category REST API
    //http://localhost:8080/api/categories/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long id){

        //delete category from database
        categoryService.deleteCategory(id);

        return new ResponseEntity<String>("Category deleted successfully!", HttpStatus.OK);
    }

}
