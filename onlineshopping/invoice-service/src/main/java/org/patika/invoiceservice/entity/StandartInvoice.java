package org.patika.invoiceservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.patika.invoiceservice.entity.Order;
import org.patika.invoiceservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StandartInvoice extends Invoice {

    public StandartInvoice(Order order) {
        super(order);

    }

    @Override
    public double calculateInvoiceTotal() {
        invoiceTotal =0.0;
        for (Product product : getOrder().getProductList()) {
            invoiceTotal += product.getProductCost();
        }
        return invoiceTotal;
    }

    @Override
    public void printInvoice() {
        System.out.println("\n"+"Standard Invoice:");
        for (Product product : getOrder().getProductList()) {
            System.out.println("Ürün Adı: " + product.getProductName() + ", Ürün Fiyatı: " + product.getProductCost());
        }
        System.out.println("Fatura Tutarı: " + invoiceTotal);
        System.out.println("Fatura Tarihi: " + invoiceDate);
    }


}
