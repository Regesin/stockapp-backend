package com.stockdelivery.exceptions;/*
 *@created 17-12-2021/12/2021 - 12:48 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException() {
    }

    public DeliveryNotFoundException(String message) {
        super(message);
    }
}
