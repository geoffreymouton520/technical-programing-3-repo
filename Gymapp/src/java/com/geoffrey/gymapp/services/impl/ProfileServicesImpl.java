/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.PersonFactory;
import com.geoffrey.gymapp.app.factory.ProfileModelFactory;
import com.geoffrey.gymapp.app.factory.UserFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.ProfileServices;
import com.geoffrey.gymapp.services.crud.PersonCrudService;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("profileServices")
public class ProfileServicesImpl implements ProfileServices{
    @Autowired
    private UserCrudService userCrudService;
    
    @Autowired
    private PersonCrudService personCrudService;
    
    @Override
    public ProfileModel getProfile(String userName) {
        Users user = userCrudService.getByPropertyName("userName", userName);
        Person person = user.getPerson();
        
        Map<String, String> modelValues = new HashMap<String, String>();
        modelValues.put("DOB", person.getDateOfBirth());
        modelValues.put("FirstName", person.getFirstName());
        modelValues.put("Gender", person.getGender().toString());
        modelValues.put("LastName", person.getLastName());
        modelValues.put("MiddleName", person.getMiddleName());
        modelValues.put("UserName", user.getUserName());
        modelValues.put("Password", user.getPassword());
        modelValues.put("DOB", person.getDateOfBirth());
        
        ProfileModelFactory profileModelFactory = ProfileModelFactory.getInstance();
        ProfileModel profileModel = profileModelFactory.getProfileModel(modelValues);
        return profileModel;
    }

    @Override
    public void updateProfile(ProfileModel profileModel) {
        String userName = profileModel.getUserName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();
        
        Long userID = tempUser.getId();
        Long personID = tempPerson.getId();
        
        Users currentUser = userCrudService.findById(userID);
        currentUser.setUserName(profileModel.getUserName());
        currentUser.setPassword(profileModel.getPassword());
        userCrudService.merge(currentUser);
        
        Person currentPerson = personCrudService.findById(personID);
        currentPerson.setDateOfBirth(profileModel.getDateOfBirth());
        currentPerson.setFirstName(profileModel.getFirstName());
        currentPerson.setGender(Gender.valueOf(profileModel.getGender()));
        currentPerson.setLastName(profileModel.getLastName());
        currentPerson.setMiddleName(profileModel.getMiddleName());
        personCrudService.merge(currentPerson);
        /*
        UserFactory userFactory = UserFactory.getInstance();
        Users user = userFactory.getUser(profileModel.getFirstName(), profileModel.getPassword());
        user.setId(userID);
        
        Map<String, String> personValues = new HashMap<String, String>();
        
        PersonFactory personFactory = PersonFactory.getInstance();
        
        Person person = personFactory.getPerson(personValues, Gender.MALE);
        person.setId(personID);
        person.s*/
    }
    
}
