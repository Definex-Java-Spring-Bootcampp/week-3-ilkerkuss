package org.patika.onlineshopservice.entities.concretes;


import org.patika.onlineshopservice.business.InvoiceManager;
import org.patika.onlineshopservice.business.OrderManager;
import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.IInvoice;
import org.patika.onlineshopservice.entities.enums.CustomerType;


import java.util.List;

public class StandartCustomer extends Customer {

    public StandartCustomer(String customerName, Integer customerAge) {
        super(customerName, customerAge);

    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.STANDART;
    }


    @Override
    public void printName() {
        System.out.println(getCustomerName() + " StandartCustomer!");
    }

    public void printAge() {
        System.out.println(getCustomerAge() + " StandartCustomer Yaşı");
    }

    @Override
    public void orderProduct(List<Product> productList) {

        Order returnOrder = OrderManager.getInstance().getOrder(productList);
        getOrderList().add(returnOrder);

        IInvoice returnInvoice = InvoiceManager.getInstance().getInvoice(returnOrder,this);
        returnOrder.setOrderInvoice(returnInvoice);

        System.out.println(getOrderList() + " ile Standart Order yapıldı.");
    }

}
