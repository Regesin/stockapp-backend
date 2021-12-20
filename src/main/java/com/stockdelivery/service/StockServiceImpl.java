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

    @Override
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {

        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(int stockId) {

        stockRepository.deleteById(stockId);
    }

    @Override
    public Stock getById(int stockId) {
        return stockRepository.findById(stockId).get();
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }


    @Override
    public List<Stock> getByType(int typeId) throws TypeNotFoundException {
        return stockRepository.findByType(typeId);
    }

    @Override
    public List<Stock> getByLesserPrice(double price) throws StockNotFoundException {
        return stockRepository.findByLesserPrice(price);
    }

    @Override
    public List<Stock> getByGreaterPrice(double price) throws StockNotFoundException {
        return stockRepository.findByGreaterPrice(price);
    }

    @Override
    public Stock getByStockName(String name) throws StockNotFoundException {
        return stockRepository.findByStockName(name);
    }

    @Override
    public Long getByVolume(int stockId) {
        return stockRepository.findByVolume(stockId);
    }

    @Override
    public List<Stock> getByExpiryDate(int typeId) throws StockNotFoundException {
        return stockRepository.findByExpiryDate(typeId);
    }
}
