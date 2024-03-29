package org.patika.onlineshopservice.business;

import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;

import java.util.List;

public class OrderManager {
    private static OrderManager orderManagerInstance;

    public static synchronized OrderManager getInstance() {
        if (orderManagerInstance == null)
            orderManagerInstance = new OrderManager();

        return orderManagerInstance;
    }

    public Order getOrder(List<Product> productList) {

        Order returnOrder = new Order(productList);
        return returnOrder;
    }
}
