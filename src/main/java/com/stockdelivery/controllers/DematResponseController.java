package com.stockdelivery.controllers;/*
 *@created 18-12-2021/12/2021 - 09:54 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;
import com.stockdelivery.model.Demat;
import com.stockdelivery.service.IDematService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/demat-api")
public class DematResponseController {
    private final IDematService dematService;

    public DematResponseController(IDematService dematService) {
        this.dematService = dematService;
    }

    private final Logger logger = LoggerFactory.getLogger(DematResponseController.class);

    @PostMapping("/demat")
    public ResponseEntity<List<Demat>> addDemat(Demat demat) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Demat");
        dematService.addDemat(demat);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }


    @PutMapping("/demat")
    public ResponseEntity<List<Demat>> updateDemat(Demat demat) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Demat");
        dematService.addDemat(demat);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/demat")
    public ResponseEntity<List<Demat>> deleteDematId(int dematId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a demat");
        dematService.deleteDematId(dematId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @GetMapping("/demat/id/{dematId}")
    public ResponseEntity<List<Demat>> getById(@PathVariable("dematId") int dematId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By Id");
        headers.add("info", "Demat details");
        Demat demats = dematService.getById(dematId);
        ResponseEntity<List<Demat>> propertyResponse = new ResponseEntity(demats, headers, HttpStatus.OK);
        return propertyResponse;

    }

    @GetMapping("/demat/deliveries/dematId/{dematId}")
    public ResponseEntity<List<Delivery>> getByDeliveries(@PathVariable("dematId") int dematId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Deliveries");
        headers.add("info", "Demat details");
        List<Delivery> deliveries = dematService.getByDeliveries(dematId);
        ResponseEntity<List<Delivery>> propertyResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return propertyResponse;
    }

    @GetMapping("/demat/dematId/{dematId}/type/{type}")
    public ResponseEntity<List<Delivery>> getByType(@PathVariable("dematId") int dematId, @PathVariable("type") DeliveryType type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Deliveries By Type");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = dematService.getByType(dematId, type);
        ResponseEntity<List<Delivery>> propertyResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return propertyResponse;
    }


    @GetMapping("/demat/dematId/{dematId}/startDate/{start}/endDate/{end}")
    public ResponseEntity<List<Delivery>> getBetweenDates(@PathVariable("dematId") int dematId, @PathVariable("start") String start, @PathVariable("end") String end) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Deliveries Between  Dates");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = dematService.getBetweenDates(dematId, start, end);
        ResponseEntity<List<Delivery>> propertyResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return propertyResponse;
    }

    @GetMapping("/demat/dematId/{dematId}/date/{date}")
    public ResponseEntity<List<Delivery>> getByIDDate(@PathVariable("dematId") int dematId, @PathVariable("date") String date) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Deliveries Between Specific Date");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = dematService.getByIDDate(dematId, date);
        ResponseEntity<List<Delivery>> propertyResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return propertyResponse;
    }


}
