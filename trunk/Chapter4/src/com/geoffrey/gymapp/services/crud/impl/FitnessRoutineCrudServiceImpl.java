/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.FitnessRoutineCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("fitnessRoutineCrudService")
@Transactional
public class FitnessRoutineCrudServiceImpl implements FitnessRoutineCrudService{

    @Autowired
    private GenericDAO<FitnessRoutine> dao;
    public final void setDAO(final GenericDAO<FitnessRoutine> dao){
        this.dao = dao;
        dao.setClazz(FitnessRoutine.class);
    }
    public FitnessRoutineCrudServiceImpl() {
    }

    @Override
    public FitnessRoutine findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<FitnessRoutine> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(FitnessRoutine entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(FitnessRoutine entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(FitnessRoutine entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        FitnessRoutine v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<FitnessRoutine> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public FitnessRoutine getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<FitnessRoutine> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
