package org.patika.onlineshopservice.controllers;

import lombok.RequiredArgsConstructor;
import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        System.out.println("OrderService: " + orderService.hashCode());
        return orderService.save(order);
    }


    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }


}
