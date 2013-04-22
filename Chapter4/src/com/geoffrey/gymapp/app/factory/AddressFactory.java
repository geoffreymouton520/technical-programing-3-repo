/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Address;
import com.geoffrey.gymapp.domain.BodyStatGoal;

/**
 *
 * @author geoffrey
 */
public class AddressFactory {
    private static AddressFactory addressFactory;

    private AddressFactory() {
    }
    
    public static AddressFactory getInstance(){
        if (addressFactory == null) {
            addressFactory = new AddressFactory();
        }
        return addressFactory;
    }
    
    public Address getAddress(String physicalAddres, String postalAddress, String postalCode){
        Address address = new Address();
       
        address.setPhysicalAddress(physicalAddres);
        address.setPostalAddress(postalAddress);
        address.setPostalCode(postalCode);
        return address;
    }
}
