package com.stockdelivery.exceptions;/*
 *@created 17-12-2021/12/2021 - 11:31 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class TypeNotFoundException extends RuntimeException {

    public TypeNotFoundException() {
    }

    public TypeNotFoundException(String message) {
        super(message);
    }
}
