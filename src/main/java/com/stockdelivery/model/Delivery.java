package com.stockdelivery.model;/*
 *@created 17-12-2021/12/2021 - 10:37 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {

    @Id
    @Column(name = "deliveryid")
    @GeneratedValue(generator = "delivery_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "delivery_seq", sequenceName = "delivery_sequence", initialValue = 1, allocationSize = 1)
    private Integer deliveryId;

    @Column(name = "deliveryquantity")
    private int deliveryQuantity;

    @Column(name = "totalprice")
    private double totalPrice;

    @Column(name = "orderdate")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeliveryType type;

    @ManyToMany(mappedBy = "deliveries")
    @JsonIgnore
    Set<Stock> stocks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dematid")
    private Demat demat;

    public Delivery(int deliveryQuantity, double totalPrice, LocalDate orderDate, DeliveryType type,
                     Demat demat) {
        this.deliveryQuantity = deliveryQuantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.type = type;
        this.demat = demat;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryQuantity=" + deliveryQuantity +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                ", type=" + type +
                ", demat=" + demat +
                '}';
    }
}
