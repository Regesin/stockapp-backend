package com.stockdelivery.model;/*
 *@created 17-12-2021/12/2021 - 10:41 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Type {

    @Id
    @Column(name = "typeid")
    @GeneratedValue(generator = "type_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "type_seq", sequenceName = "type_sequence", initialValue = 101, allocationSize = 1)
    private Integer typeId;

    private String name;

    @Column(name = "stockperlot")
    private int stockPerLot;

    @Column(name = "expirydate")
    private LocalDate expiryDate;

    public Type(String name, int stockPerLot, LocalDate expiryDate) {
        this.name = name;
        this.stockPerLot = stockPerLot;
        this.expiryDate = expiryDate;
    }
}
