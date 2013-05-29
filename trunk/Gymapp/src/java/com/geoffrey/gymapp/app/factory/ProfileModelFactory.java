/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.impl.PasswordEncryptServiceImpl;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class ProfileModelFactory {
    private static ProfileModelFactory profileModelFactory;

    private ProfileModelFactory() {
    }
    
    public static ProfileModelFactory getInstance(){
        if (profileModelFactory == null) {
            profileModelFactory = new ProfileModelFactory();
        }
        return profileModelFactory;
    }
    
    public ProfileModel getProfileModel(Map<String,String> values){
        ProfileModel profileModel = new ProfileModel();
        
        profileModel.setDateOfBirth(values.get("DOB"));
        profileModel.setFirstName(values.get("FirstName"));
        profileModel.setGender(values.get("Gender"));
        profileModel.setLastName(values.get("LastName"));
        profileModel.setMiddleName(values.get("MiddleName"));
        
        profileModel.setUserName(values.get("UserName"));
        profileModel.setPassword(values.get("Password"));
        
        return profileModel;
    }
}
