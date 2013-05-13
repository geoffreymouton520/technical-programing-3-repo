/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.UserModel;
import com.geoffrey.gymapp.services.UserConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geoffrey
 */
@Controller
public class UserController {
    private ApplicationContext ctx;
    private UserCrudService userCrudService;
    private UserConvertModelToDomain userConvertModelToDomain;
    
    
    
    
    @RequestMapping(value="/addUser")
    public String addUser() {
        return "user";
        //return new ModelAndView("user", "command", new User());
    }
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(Model model, @ModelAttribute("user") UserModel userModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        userConvertModelToDomain = (UserConvertModelToDomain) ctx.getBean("userConvertModelToDomain");
        
        Users user = userConvertModelToDomain.convertToUser(userModel);
        userCrudService.persist(user);
        return "users";
    }
    
    @RequestMapping(value = "/users")
    public String showUsers(Model model){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        userConvertModelToDomain = (UserConvertModelToDomain) ctx.getBean("userConvertModelToDomain");
        
        List<Users> users = userCrudService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    
    @RequestMapping(value = "/editUser")
    public String editUser(Model model,@RequestParam("user") long userId){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        userConvertModelToDomain = (UserConvertModelToDomain) ctx.getBean("userConvertModelToDomain");
        
        Users user = userCrudService.findById(userId);
        model.addAttribute("user", user);
        return "editUser";
    }
    
    
}
