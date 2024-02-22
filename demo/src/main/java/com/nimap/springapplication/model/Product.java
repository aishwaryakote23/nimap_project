package com.nimap.springapplication.model;

import jakarta.persistence.*;
import lombok.Data;

// Lombok annotation to automatically generate getters, setters, toString, and other boilerplate code
@Data
@Entity
@Table(name = "product_table")
public class Product {

    // Primary key for the Product entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Column definition for the product name, making it non-nullable
    @Column(name = "product_name", nullable = false)
    private String name;

    // Column definition for the product price, making it non-nullable
    @Column(name = "price", nullable = false)
    private double price;

    // Many-to-One relationship with Category, mapped by the "category_id" foreign key
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Getter and Setter for the category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter and Setter for the product name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for the product price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
