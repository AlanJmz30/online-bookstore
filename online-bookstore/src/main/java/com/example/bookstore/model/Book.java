package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String type;
    private double price;

    // Getters and setters
}
