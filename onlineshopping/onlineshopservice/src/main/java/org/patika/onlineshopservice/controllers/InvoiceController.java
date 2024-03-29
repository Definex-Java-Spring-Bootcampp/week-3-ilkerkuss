package org.patika.onlineshopservice.controllers;

import lombok.RequiredArgsConstructor;
import org.patika.onlineshopservice.entities.abstracts.Invoice;
import org.patika.onlineshopservice.services.InvoiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    public List<Invoice> getAll(){
        return invoiceService.getAll();

    }
}
