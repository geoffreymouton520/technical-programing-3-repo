/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.CustomerAddress;

/**
 *
 * @author geoffrey
 */
public class CustomerAddressFactory {
    public static CustomerAddress getCustomerAddress(String streetAddress, String postalAddress){
         CustomerAddress address = new CustomerAddress();
         address.setPostalAddress(postalAddress);
         address.setStreetAddress(streetAddress);
         return address;
     }
}
