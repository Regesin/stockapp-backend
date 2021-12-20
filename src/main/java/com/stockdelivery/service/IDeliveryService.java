package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 12:45 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;

import java.util.List;

public interface IDeliveryService {
    /**
     * @param delivery
     */
    void addDelivery(Delivery delivery);

    /**
     * @param delivery
     * @throws DeliveryNotFoundException
     */
    void updateDelivery(Delivery delivery) throws DeliveryNotFoundException;

    /**
     * @param deliveryId
     * @throws DeliveryNotFoundException
     */
    void deleteDelivery(int deliveryId) throws DeliveryNotFoundException;

    /**
     * @param deliveryId
     * @return
     * @throws DeliveryNotFoundException
     */
    Delivery getById(int deliveryId) throws DeliveryNotFoundException;

    /**
     * @return
     */
    List<Delivery> getAll();

    /**
     * @param dematId
     * @return
     * @throws DematNotFoundException
     */
    List<Delivery> getByDematId(int dematId) throws DematNotFoundException;

    /**
     * @param dematId
     * @return
     */
    List<Delivery> getNetAmount(int dematId);

    /**
     * @param date
     * @return
     */
    List<Delivery> getByOrderDate(String date);

    /**
     * @param type
     * @return
     */
    List<Delivery> getByType(String type);

}
