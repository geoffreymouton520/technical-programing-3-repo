/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.services.crud.impl;


import com.geoffrey.marksapp.domain.Student;
import com.geoffrey.marksapp.repository.GenericDAO;
import com.geoffrey.marksapp.services.crud.StudentCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("studentCrudService")
@Transactional
public class StudentCrudServiceImpl implements StudentCrudService {

    @Autowired
    private GenericDAO<Student> dao;

    public final void setDao(final GenericDAO< Student> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Student.class);
    }

    public StudentCrudServiceImpl() {
    }
    @Override
    public Student findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Student> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Student entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Student entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Student entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Student v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Student> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Student getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Student> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
