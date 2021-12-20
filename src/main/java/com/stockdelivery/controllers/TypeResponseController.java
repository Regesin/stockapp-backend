package com.stockdelivery.controllers;/*
 *@created 19-12-2021/12/2021 - 03:55 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Stock;
import com.stockdelivery.model.Type;
import com.stockdelivery.service.IStockService;
import com.stockdelivery.service.ITypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("type-api")
public class TypeResponseController {
    public final ITypeService typeService;

    public TypeResponseController(ITypeService typeService) {
        this.typeService = typeService;
    }
    private final Logger logger = LoggerFactory.getLogger(TypeResponseController.class);

    @PostMapping("/types")
    public ResponseEntity<List<Type>> addType(Type type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Type");
        typeService.addType(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @PutMapping("/types")
    public ResponseEntity<List<Type>> updateType(Type type){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Stock");
        typeService.updateType(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/types/{typeId}")
    public ResponseEntity<List<Type>> deleteType(@PathVariable("typeId") int typeId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Type");
        typeService.deleteType(typeId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/types/type/{typeId}")
    public ResponseEntity<List<Type>> getById(@PathVariable("typeId") int typeId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting a Type by ID");
        Type types = typeService.getById(typeId);
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;

    }

    @GetMapping("/types")
    public ResponseEntity<List<Type>> getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting all types");
        List<Type> types = typeService.getAll();
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;
    }


}
