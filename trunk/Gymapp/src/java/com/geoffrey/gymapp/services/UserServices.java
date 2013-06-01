/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Users;
import java.util.List;

/**
 *
 * @author 211026298
 */
public interface UserServices {
    
    public void updateUser(Users user);
    
    public List<Users> getUsers();
    
    public void addUser(Users user);
    
    public Users getUserByID(long id);
    
    public void deleteUser(long id);

    public boolean userExists(String userName);
}
