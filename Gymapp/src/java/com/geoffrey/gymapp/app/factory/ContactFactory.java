/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Contact;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class ContactFactory {
    private static ContactFactory contactFactory;

    private ContactFactory() {
    }
    
    public static ContactFactory getInstance(){
        if (contactFactory == null) {
            contactFactory = new ContactFactory();
        }
        return contactFactory;
    }
    
    public Contact getContact(Map<String,String> values){
        Contact contact = new Contact();
        
        contact.setCellPhoneNumber(values.get("CellPhoneNumber"));
        contact.setEmailAddress(values.get("EmailAddress"));
        contact.setHomeNumber(values.get("HomeNumber"));
        contact.setOfficeNumber(values.get("OfficeNumber"));
        return contact;
    }
}
