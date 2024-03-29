package org.patika.onlineshopservice.repositories;

import org.patika.onlineshopservice.entities.abstracts.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();


    public void save(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getAll() {
        return customerList;
    }
}
