package com.stockdelivery.controllers;/*
 *@created 18-12-2021/12/2021 - 09:57 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.model.Delivery;
import com.stockdelivery.service.IDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("delivery-api")
public class DeliveryResponseController {
    private final IDeliveryService deliveryService;

    public DeliveryResponseController(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    private final Logger logger = LoggerFactory.getLogger(DeliveryResponseController.class);

    @PostMapping("/deliveries")
    public ResponseEntity<List<Delivery>> addDelivery(@RequestBody Delivery delivery) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Delivery");
        deliveryService.addDelivery(delivery);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @PutMapping("/deliveries")
    public ResponseEntity<List<Delivery>> updateDelivery(@RequestBody Delivery delivery) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a property");
        deliveryService.updateDelivery(delivery);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/deliveries/{deliveryId}")
    public ResponseEntity<List<Delivery>> deleteDelivery(@PathVariable("deliveryId") int deliveryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Delivery");
        deliveryService.deleteDelivery(deliveryId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    //Not working
    @GetMapping("/deliveries/deliveryId/{deliveryId}")
    public ResponseEntity<List<Delivery>> findById(@PathVariable("deliveryId") int deliveryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting a delivery by Id");
        deliveryService.getById(deliveryId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Deliveries");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = deliveryService.getAll();
        ResponseEntity<List<Delivery>> deliveryResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return deliveryResponse;
    }

    @GetMapping("/deliveries/dematId/{dematId}")
    public ResponseEntity<List<Delivery>> findByDematId(@PathVariable("dematId") int dematId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Deliveries By DematId");
        headers.add("info", "Delivery details");
        Delivery deliveries = deliveryService.getById(dematId);
        ResponseEntity<List<Delivery>> deliveryResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return deliveryResponse;
    }

    @GetMapping("/deliveries/netAmount/{dematId}")
    public ResponseEntity<List<Delivery>> findNetAmount(@PathVariable("dematId") int dematId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Deliveries by NetAmount");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = deliveryService.getNetAmount(dematId);
        ResponseEntity<List<Delivery>> deliveryResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return deliveryResponse;
    }

    // not working
    @GetMapping("/deliveries/orderDate/{date}")
    public ResponseEntity<List<Delivery>> findByOrderDate(@PathVariable("date") String date) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Deliveries By OrderDate");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = deliveryService.getByOrderDate(date);
        ResponseEntity<List<Delivery>> deliveryResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return deliveryResponse;
    }

    @GetMapping("/deliveries/type/{type}")
    public ResponseEntity<List<Delivery>> findByType(@PathVariable("type") String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Deliveries By Type");
        headers.add("info", "Delivery details");
        List<Delivery> deliveries = deliveryService.getByType(type);
        ResponseEntity<List<Delivery>> deliveryResponse = new ResponseEntity(deliveries, headers, HttpStatus.OK);
        return deliveryResponse;
    }


}
