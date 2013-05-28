/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.UserFactory;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.RegistrationModel;
import com.geoffrey.gymapp.presentation.web.model.UserModel;
import com.geoffrey.gymapp.services.UserConvertModelToDomain;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("userConvertModelToDomain")
public class UserConvertModelToDomainImpl implements UserConvertModelToDomain{

    @Override
    public Users convertToUser(UserModel userModel) {
        UserFactory usersFactory = UserFactory.getInstance();
        
        return usersFactory.getUser(userModel.getUserName(), userModel.getPassword());
    }

    @Override
    public Users convertToUser(RegistrationModel registrationModel) {
        UserFactory usersFactory = UserFactory.getInstance();
        return usersFactory.getUser(registrationModel.getUserName(), registrationModel.getPassword());
    }
    
}
