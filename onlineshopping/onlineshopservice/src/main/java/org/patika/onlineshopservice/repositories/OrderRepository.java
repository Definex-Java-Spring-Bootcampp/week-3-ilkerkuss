package org.patika.onlineshopservice.repositories;

import org.patika.onlineshopservice.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    public void save(Order order) {
        orderList.add(order);
    }

    public List<Order> getAll() {
        return orderList;
    }
}
