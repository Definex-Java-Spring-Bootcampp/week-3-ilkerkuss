package org.patika.onlineshopservice.entities.abstracts;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.patika.onlineshopservice.entities.Order;
import org.patika.onlineshopservice.entities.Product;
import org.patika.onlineshopservice.entities.concretes.PremiumCustomer;
import org.patika.onlineshopservice.entities.concretes.StandartCustomer;
import org.patika.onlineshopservice.entities.enums.CustomerType;


import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "standart" to the StandartCustomer class
        @JsonSubTypes.Type(name = "standart", value = StandartCustomer.class),
        // Maps "type": "premium" to the PremiumCustomer class
        @JsonSubTypes.Type(name = "premium", value = PremiumCustomer.class)
        })
@Setter
@Getter
@ToString
public abstract class Customer implements ICustomer {
    private List<Order> orderList;
    private String customerName;
    private int customerAge;

    public abstract void printName();
    public abstract void printAge();
    public abstract void orderProduct(List<Product> productList);
    public abstract CustomerType getCustomerType();


    public Customer(String customerName, int customerAge) {
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.orderList = new ArrayList<>();
    }


}
