/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.crud.impl;

import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.repository.GenericDAO;
import com.geoffrey.gymapp.services.crud.MessageCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("mesageCrudService")
@Transactional
public class MessageCrudServiceImpl implements MessageCrudService{

    @Autowired
    private GenericDAO<MQMessage> dao;
    public final void setDAO(final GenericDAO<MQMessage> dao){
        this.dao = dao;
        dao.setClazz(MQMessage.class);
    }
    public MessageCrudServiceImpl() {
    }

    @Override
    public MQMessage findById(Long id) {
        setDAO(dao);
        return dao.findById(id);
    }

    @Override
    public List<MQMessage> findAll() {
        setDAO(dao);
        return dao.findAll();
    }

    @Override
    public void persist(MQMessage entity) {
        setDAO(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(MQMessage entity) {
        setDAO(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(MQMessage entity) {
        setDAO(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDAO(dao);
        MQMessage v = findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<MQMessage> findInRange(int firstResult, int maxResults) {
        setDAO(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDAO(dao);
        return dao.count();
    }

    @Override
    public MQMessage getByPropertyName(String name, String value) {
        setDAO(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<MQMessage> getEntitiesByProperName(String name, String value) {
        setDAO(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
