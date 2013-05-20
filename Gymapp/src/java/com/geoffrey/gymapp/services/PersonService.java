/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Person;
import java.util.List;

/**
 *
 * @author 211026298
 */
public interface PersonService {
    public void updatePerson(Person person);
    
    public List<Person> getPeople();
    
    public void addPerson(Person person);
    
    public Person getPersonByID(long id);
    
    public void deletePerson(long id);
}
