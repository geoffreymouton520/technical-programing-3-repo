/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("exerciseCrudService")
@Transactional
public class ExerciseCrudServiceImpl implements ExerciseCrudService{

    @Autowired
    private GenericDAO<Exercise> dao;
    public final void setDAO(final GenericDAO<Exercise> dao){
        this.dao = dao;
        dao.setClazz(Exercise.class);
    }
    public ExerciseCrudServiceImpl() {
    }

    @Override
    public Exercise findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<Exercise> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Exercise entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Exercise entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Exercise entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        Exercise v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Exercise> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public Exercise getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Exercise> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
