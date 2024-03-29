package org.patika.onlineshopservice.entities.concretes;


import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.abstracts.Invoice;

import java.time.LocalDateTime;
import java.util.Map;

public class PremiumInvoice extends Invoice {

    public PremiumInvoice(Order order, Customer customer) {
        super(order, customer);
    }

    @Override
    public double calculateInvoiceTotal() {
        invoiceTotal = 0.0;
        for (Product product : getOrder().getProductList()) {
            invoiceTotal += product.getProductCost();
        }
        return invoiceTotal;
    }

    @Override
    public void printInvoice() {
        System.out.println("\n" + "Premium Invoice:");
        for (Product product : getOrder().getProductList()) {
            System.out.println("Ürün Adı : " + product.getProductName() + ", Ürün Fiyatı: " + product.getProductCost());
        }
        System.out.println("Fatura Tutarı: " + invoiceTotal);
        System.out.println("Fatura Tarihi: " + invoiceDate);
    }


}
