/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.Roles;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.RolesCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("rolesCrudService")
@Transactional
public class RolesCrudServiceImpl implements RolesCrudService{

    @Autowired
    private GenericDAO<Roles> dao;
    public final void setDAO(final GenericDAO<Roles> dao){
        this.dao = dao;
        dao.setClazz(Roles.class);
    }
    public RolesCrudServiceImpl() {
    }

    @Override
    public Roles findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<Roles> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Roles entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Roles entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Roles entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        Roles v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Roles> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public Roles getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Roles> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
