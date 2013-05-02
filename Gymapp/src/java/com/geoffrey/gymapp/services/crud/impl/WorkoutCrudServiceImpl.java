/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.WorkoutCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("workoutCrudService")
@Transactional
public class WorkoutCrudServiceImpl implements WorkoutCrudService{

    @Autowired
    private GenericDAO<Workout> dao;
    public final void setDAO(final GenericDAO<Workout> dao){
        this.dao = dao;
        dao.setClazz(Workout.class);
    }
    public WorkoutCrudServiceImpl() {
    }

    @Override
    public Workout findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<Workout> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Workout entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Workout entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Workout entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        Workout v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Workout> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public Workout getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Workout> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
