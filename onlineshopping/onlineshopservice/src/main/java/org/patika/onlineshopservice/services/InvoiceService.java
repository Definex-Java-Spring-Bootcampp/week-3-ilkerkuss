package org.patika.onlineshopservice.services;

import org.patika.onlineshopservice.entities.abstracts.Invoice;
import org.patika.onlineshopservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository = new InvoiceRepository();

    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }
}
