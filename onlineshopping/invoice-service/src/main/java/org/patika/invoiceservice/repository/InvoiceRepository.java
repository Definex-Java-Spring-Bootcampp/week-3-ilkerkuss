package org.patika.invoiceservice.repository;

import org.patika.invoiceservice.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private List<Invoice> invoiceList = new ArrayList<>();

    public List<Invoice> getAll() {
        return invoiceList;
    }
}
