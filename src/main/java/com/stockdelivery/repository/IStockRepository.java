package com.stockdelivery.repository;/*
 *@created 17-12-2021/12/2021 - 11:14 AM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer> {
    /**
     * @param typeId
     * @return
     */
    @Query("from Stock s inner join s.types t where t.typeId=?1")
    List<Stock> findByType(int typeId);

    /**
     * @param price
     * @return
     */

    @Query("from Stock where currentPrice < ?1")
    List<Stock> findByLesserPrice(double price);

    /**
     * @param price
     * @return
     */
    @Query("from Stock where currentPrice > ?1")
    List<Stock> findByGreaterPrice(double price);

    /**
     * @param name
     * @return
     */
    @Query("from Stock where stockName=?1")
    Stock findByStockName(String name);

    /**
     * @param stockId
     * @return
     */
    @Query(value = "select sum(numberOfBuyers + numberOfSellers) as volume from stocks", nativeQuery = true)
    Long findByVolume(int stockId);

    /**
     * @param typeId
     * @return
     */
    @Query("from Stock s inner join s.types t where t.typeId=?1 order by t.expiryDate")
    List<Stock> findByExpiryDate(int typeId);

    /**
     * @param name
     * @return
     */
    @Query("from Stock s where s.stockName like ?1%")
    List<Stock> findByName(String name);


}
