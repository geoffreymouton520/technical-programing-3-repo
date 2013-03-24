/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.Demographic;
import com.startup.musicstore.domain.Name;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class CustomerFactory {
    public static Customer getCustomer(Map<String,String> values, Date dateOfBirth){
         Customer customer = new Customer();
         Name name = new Name();
         name.setFirstName(values.get("firstName"));
         name.setLastName(values.get("lastName"));
         Contact contact = new Contact();
         contact.setContactNumber(values.get("contactNumber"));
         contact.setPhoneNumber(values.get("phoneNumber"));
         Demographic demographic = new Demographic();
         demographic.setDateOfBirth(dateOfBirth);
         demographic.setGender(values.get("race"));
         demographic.setRace(values.get("gender"));
         customer.setContact(contact);
         customer.setDemographic(demographic);
         customer.setName(name);
         customer.setCustomerNumber(values.get("customerNumber"));
         return customer;
     }
}
