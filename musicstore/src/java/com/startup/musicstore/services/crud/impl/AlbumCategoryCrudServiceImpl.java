/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.crud.impl;

import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.repository.GenericDAO;
import com.startup.musicstore.services.crud.AlbumCategoryCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author geoffrey
 */
@Service("albumCategoryCrudService")
@Transactional
public class AlbumCategoryCrudServiceImpl implements AlbumCategoryCrudService{

    @Autowired
    private GenericDAO<AlbumCategory> dao;
    
    public final void setDao(final GenericDAO< AlbumCategory> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(AlbumCategory.class);
    }
    
    public AlbumCategory findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<AlbumCategory> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(AlbumCategory entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(AlbumCategory entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(AlbumCategory entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        AlbumCategory v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<AlbumCategory> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public AlbumCategory getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<AlbumCategory> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
