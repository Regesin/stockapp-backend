package com.stockdelivery.model;/*
 *@created 17-12-2021/12/2021 - 10:36 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrors {

    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;
}
