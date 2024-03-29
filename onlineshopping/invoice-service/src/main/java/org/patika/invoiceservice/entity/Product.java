package org.patika.invoiceservice.entity;


import lombok.*;
import org.patika.invoiceservice.enums.ProductType;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Product {

    private String productName;
    private double productCost;
    private ProductType productType;


}
