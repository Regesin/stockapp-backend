package com.stockdelivery.repository;/*
 *@created 17-12-2021/12/2021 - 12:43 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.DeliveryNotFoundException;
import com.stockdelivery.model.Delivery;
import com.stockdelivery.model.Demat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Integer> {
    /**
     * @param dematId
     * @return
     */
    @Query("from Delivery d inner join d.demat de where de.dematId = ?1")
    List<Delivery> findByDematId(int dematId);

    /**
     * @param dematId
     * @return
     */
    @Query(value = "select deliveryid, sum(deliveryquantity), orderdate, sum(totalprice) as netamount from type where dematid = ?1 ORDER BY orderdate", nativeQuery = true)
    List<Delivery> findByNetAmount(int dematId);

    /**
     * @param date
     * @return
     */
    @Query("from Delivery d where d.orderDate =?1")
    List<Delivery> findByOrderDate(LocalDate date);

    /**
     * @param type
     * @return
     */

    @Query("from Delivery d where d.type = ?1 order by d.orderDate")
    List<Delivery> findByType(String type);

    /**
     * @param deliveryId
     * @return
     */
    @Query("from Delivery d where d.deliveryId = ?1")
    Delivery findById(int deliveryId);


}
