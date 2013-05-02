/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.PersonCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("personCrudService")
@Transactional
public class PersonCrudServiceImpl implements PersonCrudService{

    @Autowired
    private GenericDAO<Person> dao;
    public final void setDAO(final GenericDAO<Person> dao){
        this.dao = dao;
        dao.setClazz(Person.class);
    }
    public PersonCrudServiceImpl() {
    }

    @Override
    public Person findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Person entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Person entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Person entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        Person v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Person> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public Person getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Person> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
