package org.patika.invoiceservice.service;

import org.patika.invoiceservice.repository.InvoiceRepository;
import org.patika.invoiceservice.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }
}
