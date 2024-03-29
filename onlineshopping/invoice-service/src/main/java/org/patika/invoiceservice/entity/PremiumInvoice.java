package org.patika.invoiceservice.entity;

import lombok.Builder;
import org.patika.invoiceservice.entity.Order;
import org.patika.invoiceservice.entity.Product;


public class PremiumInvoice extends Invoice {

    public PremiumInvoice(Order order) {
        super(order);

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
