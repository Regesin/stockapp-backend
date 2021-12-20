package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 12:48 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DeliveryServiceImpl implements IDeliveryService{

    private IDeliveryRepository deliveryRepository;

    @Autowired
    public void setDeliveryRepository(IDeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) throws DeliveryNotFoundException {
        deliveryRepository.save(delivery);
    }

    @Override
    public void deleteDelivery(int deliveryId) throws DeliveryNotFoundException {
        deliveryRepository.deleteById(deliveryId);
    }

    @Override
    public Delivery getById(int deliveryId) throws DeliveryNotFoundException {
        return deliveryRepository.findById(deliveryId);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public List<Delivery> getByDematId(int dematId) throws DematNotFoundException {
        return deliveryRepository.findByDematId(dematId);
    }

    @Override
    public List<Delivery> getNetAmount(int dematId) {
        return deliveryRepository.findByNetAmount(dematId);
    }

    @Override
    public List<Delivery> getByOrderDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(date, formatter);

        return deliveryRepository.findByOrderDate(startDate);
    }

    @Override
    public List<Delivery> getByType(String type) {
        return deliveryRepository.findByType(type);
    }


}
