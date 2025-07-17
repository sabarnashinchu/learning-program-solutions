package com.example.inventory.productservice.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;
    public Product() {}
    public Product(String name, int stock) { this.name = name; this.stock = stock; }
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public int getStock() { return stock; } public void setStock(int stock) { this.stock = stock; }
}
