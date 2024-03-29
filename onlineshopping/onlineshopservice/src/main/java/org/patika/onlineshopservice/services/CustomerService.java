package org.patika.onlineshopservice.services;

import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();


    public Customer save(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
