package org.patika.onlineshopservice.repositories;

import org.patika.onlineshopservice.entities.abstracts.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private List<Invoice> invoiceList = new ArrayList<>();

    public List<Invoice> getAll() {
        return invoiceList;
    }
}
