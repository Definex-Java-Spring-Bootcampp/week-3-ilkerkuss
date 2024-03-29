package org.patika.onlineshopservice.controllers;

import lombok.RequiredArgsConstructor;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        System.out.println("ProductService: " + productService.hashCode());
        return productService.save(product);
    }


    @GetMapping
    public List<Product> getAll() {

        return productService.getAll();
    }

}
