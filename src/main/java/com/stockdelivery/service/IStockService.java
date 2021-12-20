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
    /**
     * @param stock
     */
    void addStock(Stock stock);

    /**
     * @param stock
     */
    void updateStock(Stock stock);

    /**
     * @param stockId
     */
    void deleteStock(int stockId);

    /**
     * @param stockId
     * @return
     */
    Stock getById(int stockId);

    /**
     * @return
     */
    List<Stock> getAll();

    /**
     * @param typeId
     * @return
     * @throws TypeNotFoundException
     */
    List<Stock> getByType(int typeId) throws TypeNotFoundException;

    /**
     * @param price
     * @return
     * @throws StockNotFoundException
     */
    List<Stock> getByLesserPrice(double price) throws StockNotFoundException;

    /**
     * @param price
     * @return
     * @throws StockNotFoundException
     */
    List<Stock> getByGreaterPrice(double price) throws StockNotFoundException;

    /**
     * @param name
     * @return
     * @throws StockNotFoundException
     */
    List<Stock> getByName(String name) throws StockNotFoundException;

    /**
     * @param stockId
     * @return
     */
    Long getByVolume(int stockId);

    /**
     * @param typeId
     * @return
     * @throws StockNotFoundException
     */
    List<Stock> getByExpiryDate(int typeId) throws StockNotFoundException;


}
