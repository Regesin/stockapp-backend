package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 02:53 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;
import com.stockdelivery.model.Demat;

import java.time.LocalDate;
import java.util.List;

public interface IDematService {

    void addDemat(Demat demat);

    void updateDemat(Demat demat);

    void deleteDematId(int dematId) throws DematNotFoundException;

    Demat getById(int dematId) throws DematNotFoundException;


    List<Delivery> getByDeliveries(int dematId) throws DematNotFoundException;

    List<Delivery> getByType(int dematId, DeliveryType type) throws DematNotFoundException;

    List<Delivery> getBetweenDates(int dematId,String start, String end) throws DematNotFoundException;

    List<Delivery> getByIDDate(int dematId, String date) throws DematNotFoundException;

}
