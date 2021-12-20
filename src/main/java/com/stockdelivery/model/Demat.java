package com.stockdelivery.model;/*
 *@created 17-12-2021/12/2021 - 10:39 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Demat {

    @Id
    @Column(name = "dematid")
    @GeneratedValue(generator = "demat_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "demat_seq", sequenceName = "demat_sequence", initialValue =1, allocationSize = 1)
    private Integer dematId;

    @Column(name = "buyername")
    private String buyerName;

    @Column(name = "pannumber")
    private String panNumber;

    @Column(name = "balance")
    private double balance;

    public Demat(String buyerName, String panNumber, double balance) {
        this.buyerName = buyerName;
        this.panNumber = panNumber;
        this.balance = balance;
    }
}
