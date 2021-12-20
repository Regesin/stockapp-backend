package com.stockdelivery.service;/*
 *@created 17-12-2021/12/2021 - 03:13 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.stockdelivery.exceptions.TypeNotFoundException;
import com.stockdelivery.model.Type;
import com.stockdelivery.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    private ITypeRepository typeRepository;

    @Autowired
    public void setTypeRepository(ITypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * @param type
     */
    @Override
    public void addType(Type type) {
        typeRepository.save(type);
    }

    /**
     * @param type
     */
    @Override
    public void updateType(Type type) {
        typeRepository.save(type);
    }

    /**
     * @param typeId
     * @throws TypeNotFoundException
     */
    @Override
    public void deleteType(int typeId) throws TypeNotFoundException {
        typeRepository.deleteById(typeId);
    }

    /**
     * @param typeId
     * @return
     * @throws TypeNotFoundException
     */
    @Override
    public Type getById(int typeId) throws TypeNotFoundException {
        return typeRepository.findById(typeId).get();
    }

    /**
     * @return
     * @throws TypeNotFoundException
     */
    @Override
    public List<Type> getAll() throws TypeNotFoundException {
        return typeRepository.findAll();
    }

    /**
     * @param name
     * @return
     * @throws TypeNotFoundException
     */
    @Override
    public List<Type> getByName(String name) throws TypeNotFoundException {
        return typeRepository.getByName(name);
    }

    /**
     * @return
     * @throws TypeNotFoundException
     */
    @Override
    public List<Type> getByExpiryDate() throws TypeNotFoundException {
        return typeRepository.getByExpiryDate();
    }
}
