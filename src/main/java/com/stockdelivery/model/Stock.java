package com.stockdelivery.model;/*
 *@created 17-12-2021/12/2021 - 10:40 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "stockid")
    @GeneratedValue(generator = "stock_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "stock_seq", sequenceName = "stock_sequence", initialValue = 1, allocationSize = 1)
    private Integer stockId;

    @Column(name = "name")
    private String stockName;

    @Column(name = "openingprice")
    private double openingPrice;

    @Column(name = "closingprice")
    private double closingPrice;

    @Column(name = "currentprice")
    private double currentPrice;

    @Column(name = "numberofbuyers")
    private long numberOfBuyers;

    @Column(name = "numberofsellers")
    private long numberOfSellers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stock_delivery", joinColumns = @JoinColumn(name = "stockid"),
            inverseJoinColumns = @JoinColumn(name = "deliveryid"))
    @JsonIgnore
    private Set<Delivery> deliveries;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "deliveryid")
    private Set<Type> types;



    public Stock(String stockName, double openingPrice, double closingPrice, double currentPrice,
                 long numberOfBuyers, long numberOfSellers, Set<Delivery> deliveries, Set<Type> types) {
        this.stockName = stockName;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
        this.currentPrice = currentPrice;
        this.numberOfBuyers = numberOfBuyers;
        this.numberOfSellers = numberOfSellers;
        this.deliveries = deliveries;
        this.types = types;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", openingPrice=" + openingPrice +
                ", closingPrice=" + closingPrice +
                ", currentPrice=" + currentPrice +
                ", numberOfBuyers=" + numberOfBuyers +
                ", numberOfSellers=" + numberOfSellers +
                ", deliveries=" + deliveries +
                ", types=" + types +
                '}';
    }
}
