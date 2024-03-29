package org.patika.onlineshopservice.entities;

import lombok.*;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.business.InvoiceManager;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Order {

    private List<Product> productList;
    private IInvoice orderInvoice;

    public Order(List<Product> productList) {
        this.productList = productList;
    }


    public IInvoice prepareOrderInvoice(Customer customer) {
        orderInvoice = InvoiceManager.getInstance().getInvoice(this, customer);
        return orderInvoice;
    }

}



