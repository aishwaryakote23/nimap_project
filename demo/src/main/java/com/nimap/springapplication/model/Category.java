package com.nimap.springapplication.model;

import jakarta.persistence.*;
import lombok.Data;

// Lombok annotation to automatically generate getters, setters, toString, and other boilerplate code
@Data
@Entity
@Table(name = "category_table")
public class Category {

    // Primary key for the Category entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    // Column definition for the category name, making it non-nullable
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    // Getter method for retrieving the category name
    public String getName() {
        return categoryName;
    }

    // Setter method for setting the category name
    public void setName(String name) {
        this.categoryName = name;
    }
}
