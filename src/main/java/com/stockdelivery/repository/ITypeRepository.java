package com.stockdelivery.repository;/*
 *@created 17-12-2021/12/2021 - 03:10 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {
    /**
     * @param name
     * @return
     */
    @Query("from Type t where t.name like ?1% order by t.expiryDate")
    List<Type> getByName(String name);

    /**
     * @return
     */
    @Query("from Type t order by t.expiryDate")
    List<Type> getByExpiryDate();
}
