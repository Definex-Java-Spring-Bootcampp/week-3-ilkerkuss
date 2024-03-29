package org.patika.onlineshopservice.business;

import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.entities.enums.CustomerType;


import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private static CustomerManager customerManagerInstance;
    private CustomerFactory customerFactory = new CustomerFactory();
    private List<ICustomer> iCustomerList = new ArrayList<>();


    public CustomerManager() {

    }

    public static synchronized CustomerManager getInstance() {
        if (customerManagerInstance == null)
            customerManagerInstance = new CustomerManager();

        return customerManagerInstance;
    }

    private CustomerFactory getCustomerFactory() {

        return customerFactory;
    }


    /**
     * Gets customerType,customerName,customerAge as paramaters and create intended customer via CustomerFactory of CustomerManager.Add intended customer iCustomerList.
     * Returns ICustomer customer.
     */
    public ICustomer getCustomer(CustomerType customerType, String customerName, int customerAge) {

        // checking for new customer exist in our customerList
        for (ICustomer customer : iCustomerList) {
            if (customer.getCustomerName().equals(customerName) && customer.getCustomerAge() == customerAge) {
                System.out.println(customer + " Sistemde Kayıdı bulunmaktadır.");
                return customer;
            }
        }

        ICustomer returnCust = getCustomerFactory().createCustomer(customerType, customerName, customerAge);
        iCustomerList.add(returnCust);
        return returnCust;
    }


    public int getAllCustomerNumber(){
        return getiCustomerList().size();
    }

    public void getProductNumberOfCustomer(String customerName){
        getiCustomerList().stream().filter(cust -> cust.getCustomerName().equals(customerName)).forEach(cust -> cust.getOrderList().forEach(order -> System.out.println(order+" Ürün Sayısı: "+order.getProductList().size())));
    }

    public void getUsersTotalCostOfOrderWithAge(String customerName,int lowerBound,int upperBound){
        getiCustomerList().stream().filter(cust -> cust.getCustomerName().equals(customerName)).filter(cust-> (cust.getCustomerAge()>lowerBound && cust.getCustomerAge()<upperBound)).forEach(cust-> cust.getOrderList().forEach(order -> System.out.println(order.getOrderInvoice().getInvoiceTotal())));//Soru 3


    }


    public void setCustomerFactory(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    public List<ICustomer> getiCustomerList() {
        return iCustomerList;
    }
}
