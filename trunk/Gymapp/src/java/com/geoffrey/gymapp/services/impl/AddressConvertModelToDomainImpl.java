/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.AddressFactory;
import com.geoffrey.gymapp.domain.Address;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.AddressConvertModelToDomain;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("addressConvertModelToDomain")
public class AddressConvertModelToDomainImpl implements AddressConvertModelToDomain{

    @Override
    public Address convertToAddress(ProfileModel registrationModel) {
        AddressFactory addressFactory = AddressFactory.getInstance();
        Address address = addressFactory.getAddress(registrationModel.getPhysicalAddress(), registrationModel.getPostalAddress(), registrationModel.getPostalCode());
        return address;
    }
    
}
