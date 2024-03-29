package org.patika.onlineshopservice.business;

import org.patika.onlineshopservice.entities.abstracts.Customer;
import org.patika.onlineshopservice.entities.abstracts.ICustomer;
import org.patika.onlineshopservice.entities.concretes.PremiumCustomer;
import org.patika.onlineshopservice.entities.concretes.StandartCustomer;
import org.patika.onlineshopservice.entities.enums.CustomerType;

public class CustomerFactory {

    public ICustomer createCustomer(CustomerType customerType, String customerName, int customerAge) {
        switch (customerType) {
            case STANDART: {
                return new StandartCustomer(customerName, customerAge);
            }
            case PREMIUM: {
                return new PremiumCustomer(customerName,customerAge);
            }
            default:
                throw new IllegalArgumentException(customerType + " Not Found!");
        }

    }

}
