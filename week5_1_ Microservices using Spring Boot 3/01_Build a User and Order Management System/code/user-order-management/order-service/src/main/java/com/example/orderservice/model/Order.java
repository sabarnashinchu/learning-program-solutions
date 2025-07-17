package com.example.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`order`") // Escaping "order" (SQL reserved keyword)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    @Column(name = "user_id")
    private Long userId;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
}
