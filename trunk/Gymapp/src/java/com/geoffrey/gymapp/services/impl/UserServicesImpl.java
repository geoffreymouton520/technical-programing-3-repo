/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.services.UserServices;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("userServices")
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserCrudService userCrudService;
    
    @Override
    public void updateUser(Users user) {
        Users currentUser = userCrudService.findById(user.getId());
        currentUser.setUserName(user.getUserName());
        currentUser.setPassword(user.getPassword());
        currentUser.setEnabled(user.isEnabled());
        currentUser.setPerson(user.getPerson());
        currentUser.setRoles(user.getRoles());
        userCrudService.merge(currentUser);
    }

    @Override
    public List<Users> getUsers() {
        List<Users> users = userCrudService.findAll();
        return users;
    }

    @Override
    public void addUser(Users user) {
        userCrudService.persist(user);
    }

    @Override
    public Users getUserByID(long id) {
        return userCrudService.findById(id);
    }

    @Override
    public void deleteUser(long id) {
        userCrudService.removeById(id);
    }
    
    
    
}
