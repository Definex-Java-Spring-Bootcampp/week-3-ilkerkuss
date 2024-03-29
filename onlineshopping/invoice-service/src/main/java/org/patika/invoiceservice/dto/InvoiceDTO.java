package org.patika.invoiceservice.dto;

import lombok.*;
import org.patika.invoiceservice.entity.Order;
import org.patika.invoiceservice.entity.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceDTO {

    private Order order;
}
