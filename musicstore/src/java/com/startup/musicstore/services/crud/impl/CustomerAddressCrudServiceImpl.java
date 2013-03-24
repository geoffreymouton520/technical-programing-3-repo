/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.crud.impl;

import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.repository.GenericDAO;
import com.startup.musicstore.services.crud.CustomerAddressCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("customerAddressCrudService")
@Transactional
public class CustomerAddressCrudServiceImpl implements CustomerAddressCrudService {
    @Autowired
    private GenericDAO<CustomerAddress> dao;

    public final void setDao(final GenericDAO< CustomerAddress> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(CustomerAddress.class);
    }

    public CustomerAddressCrudServiceImpl() {
    }
    @Override
    public CustomerAddress findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<CustomerAddress> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(CustomerAddress entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(CustomerAddress entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(CustomerAddress entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        CustomerAddress v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<CustomerAddress> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public CustomerAddress getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<CustomerAddress> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
