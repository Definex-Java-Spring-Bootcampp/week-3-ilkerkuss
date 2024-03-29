package org.patika.onlineshopservice.entities.abstracts;


import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.enums.CustomerType;

import java.util.List;

public interface ICustomer {

    void printName();
    void printAge();

    String getCustomerName();

    int getCustomerAge();
    List<Order> getOrderList();
    void orderProduct(List<Product> productList);
    CustomerType getCustomerType();
}
