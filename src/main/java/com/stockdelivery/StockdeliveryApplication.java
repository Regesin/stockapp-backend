package com.stockdelivery;

import com.stockdelivery.model.*;
import com.stockdelivery.service.IDeliveryService;
import com.stockdelivery.service.IDematService;
import com.stockdelivery.service.IStockService;
import com.stockdelivery.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StockdeliveryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StockdeliveryApplication.class, args);
    }

    private IStockService stockService;

    private IDematService dematService;

    private IDeliveryService deliveryService;

    private ITypeService typeService;

    @Autowired
    public void setTypeService(ITypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setDeliveryService(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Autowired
    public void setDematService(IDematService dematService) {
        this.dematService = dematService;
    }

    @Autowired
    public void setStockService(IStockService stockService) {
        this.stockService = stockService;
    }


    @Override
    public void run(String... args) throws Exception {


//        Demat demat12 = dematService.getById(1);
//        Stock stock2 = stockService.getById(1);
//        Stock stock13 = stockService.getById(2);
//        Set<Stock> stockSet = new HashSet<>(Arrays.asList(stock));
//
//        System.out.println(demat1);
//        System.out.println(stockSet);
//
//        Type type5 = typeService.getById(101);
//
//        Set<Type> typeSet13 = new HashSet<>(Arrays.asList(type));
//        System.out.println("====================================================");
//        System.out.println(typeSet);
//        System.out.println("====================================================");
//        Demat demat3 = dematService.getById(1);

//        String stringDate = "10-12-2021";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate releaseDate = LocalDate.parse(stringDate, formatter);
//
//        String stringDate1 = "12-12-2021";
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate releaseDate1 = LocalDate.parse(stringDate, formatter);
//
//        String stringDate2 = "10-11-2021";
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate releaseDate2 = LocalDate.parse(stringDate, formatter);
//
//        String stringDate3 = "07-11-2021";
//        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate releaseDate3 = LocalDate.parse(stringDate, formatter);
//
//
//        Type type = new Type("DEC Futures", 250,releaseDate);
//        Type type1 = new Type("NOV Futures", 150,releaseDate1);
//        Set<Type> typeSet = new HashSet<>(Arrays.asList(type, type1));
//        Type type2 = new Type("FEB Futures", 25,releaseDate);
//        Type type3 = new Type("JAN Futures", 1500,releaseDate1);
//        Set<Type> typeSet1 = new HashSet<>(Arrays.asList(type2, type3));
//
//        Demat demat = new Demat("Arun", "CRJPK230P", 154000);
//
//        Demat demat1 = new Demat("Arjun", "AVJY26570P", 850000);
//
//        Demat demat2 = new Demat("Sabbu", "DERK87PN0", 10000000);
//
//
//
//        Delivery delivery = new Delivery(20,3050,releaseDate2,DeliveryType.BUY,demat1);
//        Delivery delivery1 = new Delivery(30, 12750.6,releaseDate3,DeliveryType.SELL, demat2);
////        deliveryService.addDelivery(delivery);
//        Set<Delivery> deliverySet = new HashSet<>(Arrays.asList(delivery));
//        Set<Delivery> deliverySet1 = new HashSet<>(Arrays.asList(delivery1));
//
//        Stock stock  = new Stock("SBIN",154.45, 155.45, 152.5, 1550045l,13200l, deliverySet,typeSet);
//        Stock stock1 = new Stock("ICICI",425.02, 420.6, 418.6, 10008000l,1547879l, deliverySet1, typeSet1);
//        stockService.addStock(stock);
//        stockService.addStock(stock1);

//        System.out.println(stockService.getByType(102));



    }
}
