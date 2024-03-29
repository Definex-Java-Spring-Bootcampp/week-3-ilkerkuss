package org.patika.onlineshopservice.entities.abstracts;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.concretes.PremiumInvoice;
import org.patika.onlineshopservice.entities.concretes.StandartInvoice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "standart" to the StandartInvoice class
        @JsonSubTypes.Type(name = "standart", value = StandartInvoice.class),
        // Maps "type": "premium" to the PremiumInvoice class
        @JsonSubTypes.Type(name = "premium", value = PremiumInvoice.class)
})
@Getter
public abstract class Invoice implements IInvoice {
    private Customer customer;
    private Order order;
    protected LocalDateTime invoiceDate;
    protected double invoiceTotal;

    public Invoice(Order order,Customer customer) {
        this.customer = customer;
        this.order = order;
        this.invoiceDate = LocalDateTime.now();
        calculateInvoiceTotal();
    }

    public abstract double calculateInvoiceTotal();
    public abstract void printInvoice();

    public Order getOrder() {
        return order;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                ", invoiceDate=" + invoiceDate +
                ", invoiceTotal=" + invoiceTotal +
                '}';
    }
}
