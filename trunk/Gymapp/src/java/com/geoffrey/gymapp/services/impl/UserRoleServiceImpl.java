/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.RolesFactory;
import com.geoffrey.gymapp.domain.UserRoles;
import com.geoffrey.gymapp.services.UserRoleService;
import com.geoffrey.gymapp.services.crud.RolesCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private RolesCrudService rolesCrudService;
    @Override
    public List<UserRoles> addUserRole(List<UserRoles> roles) {
        RolesFactory rolesFactory = RolesFactory.getInstance();
        UserRoles role = rolesFactory.getRole("ROLE_USER", "user");
        rolesCrudService.persist(role);
        roles.add(role);
        return roles;
    }
    
}
