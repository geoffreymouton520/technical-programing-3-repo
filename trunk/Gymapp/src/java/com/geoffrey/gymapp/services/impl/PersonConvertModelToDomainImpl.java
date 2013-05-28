/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.PersonFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;
import com.geoffrey.gymapp.presentation.web.model.RegistrationModel;
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
            
        Gender gender = Gender.valueOf(personModel.getGender());
        
        return personFactory.getPerson(personDetails, gender);
    }

    @Override
    public Person convertToPerson(RegistrationModel registrationModel) {
        PersonFactory personFactory = PersonFactory.getInstance();
        
        Map<String,String> personDetails = new HashMap<String,String>();
        personDetails.put("FirstName", registrationModel.getFirstName());
        personDetails.put("LastName", registrationModel.getLastName());
        personDetails.put("MiddleName", registrationModel.getMiddleName());
        personDetails.put("DOB", registrationModel.getDateOfBirth());
            
        Gender gender = Gender.valueOf(registrationModel.getGender());
        
        return personFactory.getPerson(personDetails, gender);
    }
    
}
