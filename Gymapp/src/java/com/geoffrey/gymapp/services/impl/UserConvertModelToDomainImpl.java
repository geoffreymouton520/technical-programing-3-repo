/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.UserFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.UserModel;
import com.geoffrey.gymapp.services.UserConvertModelToDomain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        return usersFactory.getUser(userModel.getUserName(), userModel.getUserName());
    }
    
}
