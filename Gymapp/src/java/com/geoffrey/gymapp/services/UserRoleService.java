/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.UserRoles;
import java.util.List;

/**
 *
 * @author 211026298
 */
public interface UserRoleService {
    public List<UserRoles> addUserRole(List<UserRoles> roles);
}
