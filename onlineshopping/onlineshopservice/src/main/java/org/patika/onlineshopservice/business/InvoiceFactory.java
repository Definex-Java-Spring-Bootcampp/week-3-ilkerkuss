package org.patika.onlineshopservice.business;


import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.concretes.PremiumInvoice;
import org.patika.onlineshopservice.entities.concretes.StandartInvoice;
import org.patika.onlineshopservice.entities.enums.CustomerType;
import org.patika.onlineshopservice.entities.enums.InvoiceType;


import java.time.LocalDateTime;
import java.util.Map;

public class InvoiceFactory {

    public IInvoice createInvoice(Order order, Customer customer) {
        switch (customer.getCustomerType()) {
            case STANDART: {
                return new StandartInvoice(order,customer);
            }
            case PREMIUM: {
                return new PremiumInvoice(order,customer);
            }
            default:
                throw new IllegalArgumentException(customer.getCustomerType() + " Not Found!");
        }

    }
}
