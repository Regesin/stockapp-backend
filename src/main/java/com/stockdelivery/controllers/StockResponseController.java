package com.stockdelivery.controllers;
/*
 *@created 17-12-2021/12/2021 - 08:34 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.model.Stock;
import com.stockdelivery.service.IStockService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("stock-api")
public class StockResponseController {

    private final IStockService stockService;

    public StockResponseController(IStockService stockService) {
        this.stockService = stockService;
    }

    private final Logger logger = LoggerFactory.getLogger(StockResponseController.class);

    @PostMapping("/stocks")
    public ResponseEntity<List<Stock>> addStock(@RequestBody Stock stock) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Stock");
        stockService.addStock(stock);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @PutMapping("/stocks")
    public ResponseEntity<List<Stock>> updateStock(@RequestBody Stock stock) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Stock");
        stockService.updateStock(stock);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/stocks/{stockId}")
    public ResponseEntity<List<Stock>> deleteStock(@PathVariable("stockId") int stockId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Stock");
        stockService.deleteStock(stockId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @GetMapping("/stocks/stockId/{stockId}")
    public ResponseEntity<List<Stock>> findById(@PathVariable("stockId") int stockId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Stock");
        Stock stocks = stockService.getById(stockId);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;
    }

    @GetMapping("/stocks")
    ResponseEntity<List<Stock>> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Stocks");
        List<Stock> stocks = stockService.getAll();
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;

    }

    @GetMapping("/stocks/type/{typeId}")
    ResponseEntity<List<Stock>> findByType(@PathVariable("typeId") int typeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By Type");
        List<Stock> stocks = stockService.getByType(typeId);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;

    }

    @GetMapping("/stocks/lesserPrice/{price}")
    ResponseEntity<List<Stock>> findByLesserPrice(@PathVariable("price") double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Stocks Less than certain" + price);
        List<Stock> stocks = stockService.getByLesserPrice(price);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;

    }

    @GetMapping("/stocks/greaterPrice/{price}")
    ResponseEntity<List<Stock>> findByGreaterPrice(@PathVariable("price") double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Stocks Greater than certain" + price);
        List<Stock> stocks = stockService.getByGreaterPrice(price);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;

    }

    @GetMapping("/stocks/name/{name}")
    ResponseEntity<List<Stock>> findByStockName(@PathVariable("name") String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Finding Name of the Stock");
        Stock stocks = stockService.getByStockName(name);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;


    }

    @GetMapping("/stocks/volume/{stockId}")
    ResponseEntity<List<Stock>> findByVolume(@PathVariable("stockId") int stockId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Finding Name of the Stock");
        Long stocks = stockService.getByVolume(stockId);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;
    }

    @GetMapping("/stocks/expiryDate/{typeId}")
    ResponseEntity<List<Stock>> findByExpiryDate(@PathVariable("typeId") int typeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all By Expiry Date");
        List<Stock> stocks = stockService.getByExpiryDate(typeId);
        ResponseEntity<List<Stock>> stockResponse = new ResponseEntity(stocks, headers, HttpStatus.OK);
        return stockResponse;

    }


}
