package org.patika.invoiceservice.entity;

import lombok.*;

import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Order {

    private List<Product> productList;


}



