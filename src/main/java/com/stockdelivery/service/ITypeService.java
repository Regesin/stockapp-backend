package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 03:11 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Type;

import java.util.List;

public interface ITypeService {

    void addType(Type type) ;

    void updateType(Type type);

    void deleteType(int typeId) throws TypeNotFoundException;

    Type getById(int typeId) throws TypeNotFoundException;

    List<Type> getAll() throws TypeNotFoundException;
}
