/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.domain.UserRoles;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.RegistrationModel;
import com.geoffrey.gymapp.presentation.web.model.UserModel;
import com.geoffrey.gymapp.services.UserConvertModelToDomain;
import com.geoffrey.gymapp.services.UserRoleService;
import com.geoffrey.gymapp.services.UserServices;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 211026298
 */
@Controller
public class RegistrationController {
    private ApplicationContext ctx;
    private UserServices userServices;
    private UserRoleService userRoleServices;
    private UserConvertModelToDomain userConvertModelToDomain;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String RegisterUser(Model model, @ModelAttribute("user") UserModel userModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userServices = (UserServices) ctx.getBean("userServices");
        userConvertModelToDomain = (UserConvertModelToDomain) ctx.getBean("userConvertModelToDomain");
        userRoleServices = (UserRoleService) ctx.getBean("userRoleService");
        
        Users user = userConvertModelToDomain.convertToUser(userModel);
        
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        userRoleServices.addUserRole(userRoles);
        user.setRoles(userRoles);
        userServices.addUser(user);
        return "index";
    }
    
    @RequestMapping(value = "/register")
    public String RegisterForm(Model model){
        model.addAttribute("genders", Gender.values());
        return "register";
    }
}
