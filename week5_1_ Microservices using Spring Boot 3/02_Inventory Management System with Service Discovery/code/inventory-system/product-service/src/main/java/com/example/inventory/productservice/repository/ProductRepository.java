package com.example.inventory.productservice.repository;
import com.example.inventory.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
