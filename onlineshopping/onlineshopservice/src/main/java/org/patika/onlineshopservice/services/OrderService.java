package org.patika.onlineshopservice.services;

import lombok.RequiredArgsConstructor;
import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.producer.InvoiceProducer;
import org.patika.onlineshopservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();

    @Autowired
    private InvoiceProducer invoiceProducer;

    public Order save(Order order) {

        orderRepository.save(order);

        invoiceProducer.sendOrderToInvoice(order);

        return order;
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }
}
