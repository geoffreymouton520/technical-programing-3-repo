/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class PersonFactory {
    private static PersonFactory personFactory;

    private PersonFactory() {
    }
    
    public static PersonFactory getInstance(){
        if (personFactory == null) {
            personFactory = new PersonFactory();
        }
        return personFactory;
    }
    
    public Person getPerson(Map<String,String> values,Gender gender, Date dateOfBirth){
        Person person = new Person();
        
        person.setDateOfBirth(dateOfBirth);
        person.setFirstName(values.get("FirstName"));
        person.setGender(gender);
        person.setLastName(values.get("LastName"));
        person.setMiddleName(values.get("MiddleName"));
        
        return person;
    }
}
