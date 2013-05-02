/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("usersCrudService")
@Transactional
public class UserCrudServiceImpl implements UserCrudService{

    @Autowired
    private GenericDAO<Users> dao;
    public final void setDAO(final GenericDAO<Users> dao){
        this.dao = dao;
        dao.setClazz(Users.class);
    }
    public UserCrudServiceImpl() {
    }

    @Override
    public Users findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<Users> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Users entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Users entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Users entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        Users v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Users> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public Users getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Users> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
