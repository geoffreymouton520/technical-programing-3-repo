/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.services.PersonService;
import com.geoffrey.gymapp.services.crud.PersonCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonCrudService personCrudService;
    
    @Override
    public void updatePerson(Person person) {
        Person currentPerson = personCrudService.findById(person.getId());
        currentPerson.setDateOfBirth(person.getDateOfBirth());
        currentPerson.setFirstName(person.getFirstName());
        currentPerson.setGender(person.getGender());
        currentPerson.setLastName(person.getLastName());
        currentPerson.setMiddleName(person.getMiddleName());
        personCrudService.merge(currentPerson);
    }

    @Override
    public List<Person> getPeople() {
        List<Person> people = personCrudService.findAll();
        
        return people;
    }

    @Override
    public void addPerson(Person person) {
        personCrudService.persist(person);
    }

    @Override
    public Person getPersonByID(long id) {
        return personCrudService.findById(id);
    }

    @Override
    public void deletePerson(long id) {
        personCrudService.removeById(id);
    }
    
    
    
}
