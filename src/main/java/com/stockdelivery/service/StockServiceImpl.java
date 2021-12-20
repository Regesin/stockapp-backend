package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 11:40 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.StockNotFoundException;
import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Stock;
import com.stockdelivery.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

    private IStockRepository stockRepository;

    @Autowired
    public void setStockRepository(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * @param stock
     */
    @Override
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    /**
     * @param stock
     */
    @Override
    public void updateStock(Stock stock) {

        stockRepository.save(stock);
    }

    /**
     * @param stockId
     */
    @Override
    public void deleteStock(int stockId) {

        stockRepository.deleteById(stockId);
    }

    /**
     * @param stockId
     * @return
     */
    @Override
    public Stock getById(int stockId) {
        return stockRepository.findById(stockId).get();
    }

    /**
     * @return
     */
    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    /**
     * @param typeId
     * @return
     * @throws TypeNotFoundException
     */
    @Override
    public List<Stock> getByType(int typeId) throws TypeNotFoundException {
        return stockRepository.findByType(typeId);
    }

    /**
     * @param price
     * @return
     * @throws StockNotFoundException
     */
    @Override
    public List<Stock> getByLesserPrice(double price) throws StockNotFoundException {
        return stockRepository.findByLesserPrice(price);
    }

    /**
     * @param price
     * @return
     * @throws StockNotFoundException
     */
    @Override
    public List<Stock> getByGreaterPrice(double price) throws StockNotFoundException {
        return stockRepository.findByGreaterPrice(price);
    }

    /**
     * @param name
     * @return
     * @throws StockNotFoundException
     */
    @Override
    public List<Stock> getByName(String name) throws StockNotFoundException {
        return stockRepository.findByName(name);
    }

    /**
     * @param stockId
     * @return
     */
    @Override
    public Long getByVolume(int stockId) {
        return stockRepository.findByVolume(stockId);
    }

    /**
     * @param typeId
     * @return
     * @throws StockNotFoundException
     */
    @Override
    public List<Stock> getByExpiryDate(int typeId) throws StockNotFoundException {
        return stockRepository.findByExpiryDate(typeId);
    }
}
