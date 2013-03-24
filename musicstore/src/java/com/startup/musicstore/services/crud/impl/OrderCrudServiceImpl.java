/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.crud.impl;

import com.startup.musicstore.domain.Order;
import com.startup.musicstore.repository.GenericDAO;
import com.startup.musicstore.services.crud.OrderCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("orderCrudService")
@Transactional
public class OrderCrudServiceImpl implements OrderCrudService {

    @Autowired
    private GenericDAO<Order> dao;

    public final void setDao(final GenericDAO< Order> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Order.class);
    }

    public OrderCrudServiceImpl() {
    }
    @Override
    public Order findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Order> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Order entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Order entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Order entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Order v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Order> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Order getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Order> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
