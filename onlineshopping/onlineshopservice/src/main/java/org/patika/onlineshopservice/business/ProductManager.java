package org.patika.onlineshopservice.business;


import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.enums.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager productManagerInstance;
    private List<Product> productList = new ArrayList<>();

    public static synchronized ProductManager getInstance() {
        if (productManagerInstance == null)
            productManagerInstance = new ProductManager();

        return productManagerInstance;
    }

    public Product getProduct(String productName, double productCost, ProductType productType){
        Product returnProduct = new Product(productName,productCost,productType);
        productList.add(returnProduct);
        return returnProduct;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
