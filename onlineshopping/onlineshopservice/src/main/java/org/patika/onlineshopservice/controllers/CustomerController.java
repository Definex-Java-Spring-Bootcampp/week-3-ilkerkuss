package org.patika.onlineshopservice.controllers;

import lombok.RequiredArgsConstructor;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        System.out.println("CustomerService: " + customerService.hashCode());
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }


}
