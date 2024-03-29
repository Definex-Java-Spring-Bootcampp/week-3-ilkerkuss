package org.patika.onlineshopservice.exceptions;

public class OnlineShopException extends RuntimeException {

    private String message;

    public OnlineShopException(String message) {
        super(message);
        this.message = message;
    }
}
