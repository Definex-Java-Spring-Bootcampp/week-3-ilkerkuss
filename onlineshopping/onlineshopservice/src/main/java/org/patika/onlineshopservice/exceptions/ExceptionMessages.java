package org.patika.onlineshopservice.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String CUSTOMER_NOT_FOUND = "Müşteri Bulunamadı!...";
    public static final String PRODUCT_NOT_FOUND = "Ürün Bulunamadı!...";
    public static final String INVOICE_NOT_FOUND = "Fatura Bulunamadı!...";
}
