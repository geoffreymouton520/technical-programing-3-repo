/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.presentation.web.model.UserModel;

/**
 *
 * @author geoffrey
 */
public interface UserConvertModelToDomain {
    public Users convertToUser(UserModel userModel);
    public Users convertToUser(ProfileModel registrationModel);
}
