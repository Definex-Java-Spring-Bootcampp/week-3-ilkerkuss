package org.patika.invoiceservice.controller;

import lombok.RequiredArgsConstructor;

import org.patika.invoiceservice.service.InvoiceService;
import org.patika.invoiceservice.entity.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAll(){
        return invoiceService.getAll();

    }
}
