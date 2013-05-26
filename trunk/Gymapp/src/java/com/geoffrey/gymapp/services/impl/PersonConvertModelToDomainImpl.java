/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.PersonFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("personConvertModelToDomain")
public class PersonConvertModelToDomainImpl implements PersonConvertModelToDomain{

    @Override
    public Person convertToPerson(PersonModel personModel) {
        PersonFactory personFactory = PersonFactory.getInstance();
        
        Map<String,String> personDetails = new HashMap<String,String>();
        personDetails.put("FirstName", personModel.getFirstName());
        personDetails.put("LastName", personModel.getLastName());
        personDetails.put("MiddleName", personModel.getMiddleName());
        personDetails.put("DOB", personModel.getDateOfBirth());
        /*Date dateOfBirth = null;
        DateFormat df = new SimpleDateFormat("dd-mm-yy"); 
        try {
            dateOfBirth = (Date)df.parse(personModel.getDateOfBirth());
        } catch (ParseException ex) {
            Logger.getLogger(PersonConvertModelToDomainImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
        Gender gender = Gender.valueOf(personModel.getGender());
        
        return personFactory.getPerson(personDetails, gender);
    }
    
}
