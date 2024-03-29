package org.patika.onlineshopservice.entities;


import lombok.*;
import org.patika.onlineshopservice.entities.abstracts.IProduct;
import org.patika.onlineshopservice.entities.enums.ProductType;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Product implements IProduct {

    private String productName;
    private double productCost;
    private ProductType productType;


}
