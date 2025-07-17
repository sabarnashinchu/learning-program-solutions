package com.example.inventory.inventoryservice.model;

public class Product {
    private Long id;
    private String name;
    private int stock;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public int getStock() { return stock; } public void setStock(int stock) { this.stock = stock; }
}
