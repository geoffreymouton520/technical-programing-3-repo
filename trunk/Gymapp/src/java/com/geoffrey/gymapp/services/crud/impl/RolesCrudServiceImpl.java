/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.UserRoles;
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
    private GenericDAO<UserRoles> dao;
    public final void setDAO(final GenericDAO<UserRoles> dao){
        this.dao = dao;
        dao.setClazz(UserRoles.class);
    }
    public RolesCrudServiceImpl() {
    }

    @Override
    public UserRoles findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<UserRoles> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(UserRoles entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(UserRoles entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(UserRoles entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        UserRoles v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<UserRoles> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public UserRoles getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<UserRoles> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
