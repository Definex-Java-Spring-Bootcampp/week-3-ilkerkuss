package org.patika.onlineshopservice.repositories;

import org.patika.onlineshopservice.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList = new ArrayList<>();
    public void save(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return productList;
    }
}
