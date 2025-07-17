package com.example.inventory.inventoryservice.feign;

import com.example.inventory.inventoryservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
