/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.services.impl.PasswordEncryptServiceImpl;

/**
 *
 * @author geoffrey
 */
public class UserFactory {
    private static UserFactory userFactory;
    private UserFactory() {
    }
    
    public static UserFactory getInstance(){
        if (userFactory == null) {
            userFactory = new UserFactory();
        }
        return userFactory;
    }
    
    public Users getUser(String username, String password){
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(PasswordEncryptServiceImpl.encrypt(password));
        user.setEnabled(true);
        return user;
    }
}
