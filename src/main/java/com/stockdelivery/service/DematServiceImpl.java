package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 02:55 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;
import com.stockdelivery.model.Demat;
import com.stockdelivery.repository.IDematRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DematServiceImpl implements IDematService {

    private IDematRepository dematRepository;

    @Autowired
    public void setDematRepository(IDematRepository dematRepository) {
        this.dematRepository = dematRepository;
    }

    /**
     * @param demat
     */
    @Override
    public void addDemat(Demat demat) {
        dematRepository.save(demat);
    }

    /**
     * @param demat
     */
    @Override
    public void updateDemat(Demat demat) {
        dematRepository.save(demat);
    }

    /**
     * @param dematId
     */
    @Override
    public void deleteDematId(int dematId) {
        dematRepository.deleteById(dematId);
    }

    /**
     * @param dematId
     * @return
     */
    @Override
    public Demat getById(int dematId) {
        return dematRepository.findById(dematId).get();
    }

    /**
     * @param dematId
     * @return
     * @throws DematNotFoundException
     */
    @Override
    public List<Delivery> getByDeliveries(int dematId) throws DematNotFoundException {
        return dematRepository.getByDeliveries(dematId);
    }

    /**
     * @param dematId
     * @param type
     * @return
     * @throws DematNotFoundException
     */
    @Override
    public List<Delivery> getByType(int dematId, DeliveryType type) throws DematNotFoundException {
        return dematRepository.getByType(dematId, type);
    }

    /**
     * @param dematId
     * @param start
     * @param end
     * @return
     * @throws DematNotFoundException
     */
    @Override
    public List<Delivery> getBetweenDates(int dematId, String start, String end) throws DematNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        List<Delivery> deliveries = dematRepository.getBetweenDates(dematId, startDate, endDate);
        return deliveries;
    }

    /**
     * @param dematId
     * @param date
     * @return
     * @throws DematNotFoundException
     */
    @Override
    public List<Delivery> getByIDDate(int dematId, String date) throws DematNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(date, formatter);
        List<Delivery> deliveries = dematRepository.getByIDDate(dematId, startDate);
        return deliveries;
    }


}
