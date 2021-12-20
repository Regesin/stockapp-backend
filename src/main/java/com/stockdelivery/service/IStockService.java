package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 11:16 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.StockNotFoundException;
import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Stock;

import java.util.List;

public interface IStockService {

    void addStock(Stock stock);

    void updateStock(Stock stock);

    void deleteStock(int stockId);

    Stock getById(int stockId);

    List<Stock> getAll();

    List<Stock> getByType(int typeId) throws TypeNotFoundException;

    List<Stock> getByLesserPrice(double price) throws StockNotFoundException;

    List<Stock> getByGreaterPrice(double price) throws StockNotFoundException;

    Stock getByStockName(String name) throws StockNotFoundException;

    Long getByVolume(int stockId);

    List<Stock> getByExpiryDate(int typeId) throws StockNotFoundException;



}
