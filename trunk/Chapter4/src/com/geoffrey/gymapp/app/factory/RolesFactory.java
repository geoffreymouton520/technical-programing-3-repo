/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.Roles;
import com.geoffrey.gymapp.domain.StatGroup;

/**
 *
 * @author geoffrey
 */
public class RolesFactory {
    private static RolesFactory rolesFactory;

    private RolesFactory() {
    }
    
    public static RolesFactory getInstance(){
        if (rolesFactory == null) {
            rolesFactory = new RolesFactory();
        }
        return rolesFactory;
    }
    
    public Roles getRole(String roleName, String description){
        Roles role = new Roles();
       
        role.setRoleName(roleName);
        role.setDescription(description);
        return role;
    }
}
