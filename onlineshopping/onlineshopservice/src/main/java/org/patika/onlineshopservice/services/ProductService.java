package org.patika.onlineshopservice.services;

import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository = new ProductRepository();
    public Product save(Product product) {

        productRepository.save(product);

        return product;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
