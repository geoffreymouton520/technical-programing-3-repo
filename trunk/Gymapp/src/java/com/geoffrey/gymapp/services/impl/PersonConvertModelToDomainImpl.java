/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.PersonFactory;
import com.geoffrey.gymapp.app.factory.PreferencesFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.MeasuringUnit;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
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
        PreferencesFactory preferencesFactory = PreferencesFactory.getInstance();
        Preferences preferences = preferencesFactory.getPreferences(MeasuringUnit.METRIC, 60);
        Map<String,String> personDetails = new HashMap<String,String>();
        personDetails.put("FirstName", personModel.getFirstName());
        personDetails.put("LastName", personModel.getLastName());
        personDetails.put("MiddleName", personModel.getMiddleName());
        personDetails.put("DOB", personModel.getDateOfBirth());
           
        Gender gender = Gender.valueOf(personModel.getGender());
        
        Person person = personFactory.getPerson(personDetails, gender);
        person.setPreferences(preferences);
        return person;
    }

    @Override
    public Person convertToPerson(ProfileModel registrationModel) {
        PersonFactory personFactory = PersonFactory.getInstance();
        PreferencesFactory preferencesFactory = PreferencesFactory.getInstance();
        Preferences preferences = preferencesFactory.getPreferences(MeasuringUnit.METRIC, 60);
        Map<String,String> personDetails = new HashMap<String,String>();
        personDetails.put("FirstName", registrationModel.getFirstName());
        personDetails.put("LastName", registrationModel.getLastName());
        personDetails.put("MiddleName", registrationModel.getMiddleName());
        personDetails.put("DOB", registrationModel.getDateOfBirth());
            
        Gender gender = Gender.valueOf(registrationModel.getGender());
        
        Person person = personFactory.getPerson(personDetails, gender);
        person.setPreferences(preferences);
        return person;
    }
    
}
