package com.stockdelivery.exceptions;/*
 *@created 17-12-2021/12/2021 - 08:43 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Method not allowed");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Media type not supported");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Path Variable is missing");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Request Parameter is missing");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Data type mismatch");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @ExceptionHandler(value = StockNotFoundException.class)
    public ResponseEntity<Object> handleStockNotFound(StockNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Stock not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = TypeNotFoundException.class)
    public ResponseEntity<Object> handleTypeNotFound(StockNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Type not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = DematNotFoundException.class)
    public ResponseEntity<Object> handleDematNotFound(DematNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Demat not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = DeliveryNotFoundException.class)
    public ResponseEntity<Object> handleDeliveryNotFound(DeliveryNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Delivery not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Other exceptions errors" + ex.getMessage());
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }


}
