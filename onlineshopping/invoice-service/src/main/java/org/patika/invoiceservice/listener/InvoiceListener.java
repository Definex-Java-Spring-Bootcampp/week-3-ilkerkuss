package org.patika.invoiceservice.listener;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.patika.invoiceservice.dto.InvoiceDTO;
import org.patika.invoiceservice.entity.Invoice;
import org.patika.invoiceservice.entity.Order;
import org.patika.invoiceservice.entity.Product;
import org.patika.invoiceservice.entity.StandartInvoice;
import org.patika.invoiceservice.repository.InvoiceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
@Getter
@Setter
public class InvoiceListener {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void sendInvoice(Order incomeOrder) {

        log.info("Shopping Queue Info: {}", incomeOrder);

        Invoice invoice = new StandartInvoice(incomeOrder);
        invoiceRepository.getAll().add(invoice);


    }
}
