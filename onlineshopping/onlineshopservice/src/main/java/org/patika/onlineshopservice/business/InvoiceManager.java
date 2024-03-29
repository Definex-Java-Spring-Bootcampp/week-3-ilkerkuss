package org.patika.onlineshopservice.business;


import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.enums.CustomerType;
import org.patika.onlineshopservice.entities.enums.InvoiceType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvoiceManager {
    private static InvoiceManager invoiceManagerInstance;

    private final InvoiceFactory invoiceFactory=new InvoiceFactory();
    private final List<IInvoice> iInvoicesList = new ArrayList<>();

    public static synchronized InvoiceManager getInstance() {

        if (invoiceManagerInstance == null) {
            invoiceManagerInstance = new InvoiceManager();
        }
        return invoiceManagerInstance;

    }

    private InvoiceFactory getInvoiceFactory() {

        return invoiceFactory;
    }

    public List<IInvoice> getiInvoicesList() {
        return iInvoicesList;
    }

    public IInvoice getInvoice(Order order, Customer customer) {

        IInvoice returnInvoice = getInvoiceFactory().createInvoice(order,customer);
        iInvoicesList.add(returnInvoice);
        return returnInvoice;
    }

public void listInvoicesWithBoundary(int boundary){
    getiInvoicesList().stream().filter(iInvoice -> iInvoice.getInvoiceTotal()<boundary).forEach(iInvoice -> iInvoice.printInvoice());
}

}
