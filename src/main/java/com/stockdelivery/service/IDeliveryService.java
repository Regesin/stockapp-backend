package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 12:45 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;

import java.time.LocalDate;
import java.util.List;

public interface IDeliveryService {

    void addDelivery(Delivery delivery);

    void updateDelivery(Delivery delivery) throws DeliveryNotFoundException;

    void deleteDelivery(int deliveryId) throws DeliveryNotFoundException;

    Delivery getById(int deliveryId) throws  DeliveryNotFoundException;

    List<Delivery> getAll();

    List<Delivery> getByDematId(int dematId) throws DematNotFoundException;

    List<Delivery> getNetAmount(int dematId);

    List<Delivery> getByOrderDate(String date);

    List<Delivery> getByType(String type);

}
