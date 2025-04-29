package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private String id;
    private int points;

    public Customer() {}

    public Customer(String id, int points) {
        this.id = id;
        this.points = points;
    }

    // Getters and setters
}
