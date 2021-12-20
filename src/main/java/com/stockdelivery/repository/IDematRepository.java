package com.stockdelivery.repository;/*
 *@created 17-12-2021/12/2021 - 02:51 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.exceptions.DematNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.DeliveryType;
import com.stockdelivery.model.Demat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDematRepository extends JpaRepository<Demat, Integer> {
    /**
     * @param dematId
     * @return
     */
    @Query("from Delivery d inner join d.demat de where de.dematId = ?1")
    List<Delivery> getByDeliveries(int dematId);

    /**
     * @param dematId
     * @param type
     * @return
     */
    @Query("from Delivery d inner join d.demat de where de.dematId = ?1 and d.type = ?2")
    List<Delivery> getByType(int dematId, DeliveryType type);

    /**
     * @param dematId
     * @param start
     * @param end
     * @return
     */
    @Query("from Delivery d inner join d.demat de where (d.orderDate between ?2 and ?3) and de.dematId = ?1")
    List<Delivery> getBetweenDates(int dematId, LocalDate start, LocalDate end);

    /**
     * @param dematId
     * @param date
     * @return
     */
    @Query("from Delivery d inner join d.demat de where de.dematId=?1 and d.orderDate=?2")
    List<Delivery> getByIDDate(int dematId, LocalDate date);

}
