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
    /**
     * @param demat
     */
    void addDemat(Demat demat);

    /**
     * @param demat
     */
    void updateDemat(Demat demat);

    /**
     * @param dematId
     * @throws DematNotFoundException
     */
    void deleteDematId(int dematId) throws DematNotFoundException;

    /**
     * @param dematId
     * @return
     * @throws DematNotFoundException
     */
    Demat getById(int dematId) throws DematNotFoundException;

    /**
     * @param dematId
     * @return
     * @throws DematNotFoundException
     */
    List<Delivery> getByDeliveries(int dematId) throws DematNotFoundException;

    /**
     * @param dematId
     * @param type
     * @return
     * @throws DematNotFoundException
     */
    List<Delivery> getByType(int dematId, DeliveryType type) throws DematNotFoundException;

    /**
     * @param dematId
     * @param start
     * @param end
     * @return
     * @throws DematNotFoundException
     */
    List<Delivery> getBetweenDates(int dematId, String start, String end) throws DematNotFoundException;

    /**
     * @param dematId
     * @param date
     * @return
     * @throws DematNotFoundException
     */
    List<Delivery> getByIDDate(int dematId, String date) throws DematNotFoundException;

}
