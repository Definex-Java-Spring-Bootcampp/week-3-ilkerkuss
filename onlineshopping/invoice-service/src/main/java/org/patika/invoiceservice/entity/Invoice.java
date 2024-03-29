package org.patika.invoiceservice.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "standart" to the StandartInvoice class
        @JsonSubTypes.Type(name = "standart", value = StandartInvoice.class),
        // Maps "type": "premium" to the PremiumInvoice class
        @JsonSubTypes.Type(name = "premium", value = PremiumInvoice.class)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Invoice implements IInvoice {

    private Order order;
    protected LocalDateTime invoiceDate;
    protected double invoiceTotal;

    public Invoice(Order order) {
        this.order = order;
        invoiceDate = LocalDateTime.now();
        calculateInvoiceTotal();
    }

    public abstract double calculateInvoiceTotal();
    public abstract void printInvoice();

}
