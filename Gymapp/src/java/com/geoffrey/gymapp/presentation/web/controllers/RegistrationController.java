/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Address;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.UserRoles;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.AddressConvertModelToDomain;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import com.geoffrey.gymapp.services.PersonService;
import com.geoffrey.gymapp.services.UserConvertModelToDomain;
import com.geoffrey.gymapp.services.UserRoleService;
import com.geoffrey.gymapp.services.UserServices;
import java.util.ArrayList;
import java.util.List;
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
    private PersonService personService;
    private PersonConvertModelToDomain personConvertModelToDomain;
    private AddressConvertModelToDomain addressConvertModelToDomain;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String RegisterUser(Model model, @ModelAttribute("user") ProfileModel registrationModel) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userServices = (UserServices) ctx.getBean("userServices");
        userConvertModelToDomain = (UserConvertModelToDomain) ctx.getBean("userConvertModelToDomain");
        userRoleServices = (UserRoleService) ctx.getBean("userRoleService");
        personService = (PersonService) ctx.getBean("personService");
        personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        addressConvertModelToDomain = (AddressConvertModelToDomain) ctx.getBean("addressConvertModelToDomain");

        if (userServices.userExists(registrationModel.getUserName())) {
            model.addAttribute("errormessage", "Username already exists.");
            model.addAttribute("genders", Gender.values());
            return "register";
        } else {
            Users user = userConvertModelToDomain.convertToUser(registrationModel);
            List<UserRoles> userRoles = new ArrayList<UserRoles>();
            userRoleServices.addUserRole(userRoles);
            user.setRoles(userRoles);
            userServices.addUser(user);

            Person person = personConvertModelToDomain.convertToPerson(registrationModel);
            person.setUser(user);

            Address address = addressConvertModelToDomain.convertToAddress(registrationModel);
            List<Address> addresses = new ArrayList<Address>();
            addresses.add(address);
            person.setAddresses(addresses);

            personService.addPerson(person);

            user.setPerson(person);

            userServices.updateUser(user);
            return "index";
        }
    }

    @RequestMapping(value = "/register")
    public String RegisterForm(Model model) {
        model.addAttribute("genders", Gender.values());
        return "register";
    }
}
