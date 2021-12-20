package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 03:11 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Type;

import java.util.List;

public interface ITypeService {
    /**
     * @param type
     */
    void addType(Type type);

    /**
     * @param type
     */
    void updateType(Type type);

    /**
     * @param typeId
     * @throws TypeNotFoundException
     */
    void deleteType(int typeId) throws TypeNotFoundException;

    /**
     * @param typeId
     * @return
     * @throws TypeNotFoundException
     */
    Type getById(int typeId) throws TypeNotFoundException;

    /**
     * @return
     * @throws TypeNotFoundException
     */
    List<Type> getAll() throws TypeNotFoundException;

    /**
     * @param name
     * @return
     * @throws TypeNotFoundException
     */
    List<Type> getByName(String name) throws TypeNotFoundException;

    /**
     * @return
     * @throws TypeNotFoundException
     */
    List<Type> getByExpiryDate() throws TypeNotFoundException;
}
