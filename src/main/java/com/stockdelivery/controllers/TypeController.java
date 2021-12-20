package com.stockdelivery.controllers;/*
 *@created 19-12-2021/12/2021 - 03:55 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.model.Type;
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
public class TypeController {
    public final ITypeService typeService;

    public TypeController(ITypeService typeService) {
        this.typeService = typeService;
    }

    private final Logger logger = LoggerFactory.getLogger(TypeController.class);

    /**
     * @param type
     * @return
     */
    @PostMapping("/types")
    public ResponseEntity<List<Type>> addType(Type type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Type");
        typeService.addType(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    /**
     * @param type
     * @return
     */
    @PutMapping("/types")
    public ResponseEntity<List<Type>> updateType(Type type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Stock");
        typeService.updateType(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    /**
     * @param typeId
     * @return
     */
    @DeleteMapping("/types/{typeId}")
    public ResponseEntity<List<Type>> deleteType(@PathVariable("typeId") int typeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Type");
        typeService.deleteType(typeId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     * @param typeId
     * @return
     */
    @GetMapping("/types/type/{typeId}")
    public ResponseEntity<List<Type>> getById(@PathVariable("typeId") int typeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting a Type by ID");
        Type types = typeService.getById(typeId);
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;

    }

    /**
     * @return
     */
    @GetMapping("/types")
    public ResponseEntity<List<Type>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting all types");
        List<Type> types = typeService.getAll();
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;
    }

    /**
     * @param name
     * @return
     */
    @GetMapping("/types/name/{name}")
    public ResponseEntity<List<Type>> getByName(@PathVariable("name") String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting by name types");
        List<Type> types = typeService.getAll();
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;
    }

    /**
     * @return
     */
    @GetMapping("/types/date")
    public ResponseEntity<List<Type>> getByExpiryDate() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " getting by date");
        List<Type> types = typeService.getByExpiryDate();
        ResponseEntity<List<Type>> typeResponse = new ResponseEntity(types, headers, HttpStatus.OK);
        return typeResponse;
    }
}
