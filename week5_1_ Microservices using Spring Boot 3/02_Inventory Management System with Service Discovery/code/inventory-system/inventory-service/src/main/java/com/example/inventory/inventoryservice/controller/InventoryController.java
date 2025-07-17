package com.example.inventory.inventoryservice.controller;

import com.example.inventory.inventoryservice.feign.ProductClient;
import com.example.inventory.inventoryservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final ProductClient productClient;

    public InventoryController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventory(@PathVariable("id") Long id) {
        Product p;
        try {
            p = productClient.getProductById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(500)
                .body(Map.of("error", "Unable to retrieve product from Product Service", "details", ex.getMessage()));
        }
        if (p == null || p.getId() == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Product not found", "id", id));
        }
        return ResponseEntity.ok(Map.of(
            "id", p.getId(),
            "name", p.getName(),
            "stock", p.getStock()
        ));
    }
}
