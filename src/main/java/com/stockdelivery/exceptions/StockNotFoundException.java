package com.stockdelivery.exceptions;/*
 *@created 17-12-2021/12/2021 - 11:30 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException() {
    }

    public StockNotFoundException(String message) {
        super(message);
    }
}
