/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Address;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;

/**
 *
 * @author geoffrey
 */
public interface AddressConvertModelToDomain {

    public Address convertToAddress(ProfileModel registrationModel);
    
}
