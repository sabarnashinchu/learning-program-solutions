package com.example.inventory.productservice.controller;
import com.example.inventory.productservice.model.Product;
import com.example.inventory.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
