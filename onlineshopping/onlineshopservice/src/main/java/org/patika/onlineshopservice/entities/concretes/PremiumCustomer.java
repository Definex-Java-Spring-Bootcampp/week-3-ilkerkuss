package org.patika.onlineshopservice.entities.concretes;


import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.enums.CustomerType;
import org.patika.onlineshopservice.business.OrderManager;
import org.patika.onlineshopservice.business.InvoiceManager;

import java.util.List;

public class PremiumCustomer extends Customer {

    @Override
    public void printName() {
        System.out.println(getCustomerName()+" PremiumCustomer");
    }

    @Override
    public void printAge() {
        System.out.println(getCustomerAge() + " PremiumCustomer Yaşı");
    }

    @Override
    public void orderProduct(List<Product> productList) {

        Order returnOrder = OrderManager.getInstance().getOrder(productList);
        getOrderList().add(returnOrder);

        IInvoice returnInvoice = InvoiceManager.getInstance().getInvoice(returnOrder,this);
        returnOrder.setOrderInvoice(returnInvoice);

        System.out.println(getOrderList()+" ile Premium Order yapıldı.");
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.PREMIUM;
    }


    public PremiumCustomer(String customerName, Integer customerAge) {
        super(customerName, customerAge);
    }
}
