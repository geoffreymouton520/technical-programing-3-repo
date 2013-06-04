/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.MeasuringUnit;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.PreferenceModel;
import com.geoffrey.gymapp.services.PreferenceConvertModelToDomain;
import com.geoffrey.gymapp.services.PersonService;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.security.Principal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author geoffrey
 */
@Controller
public class PreferenceController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private PreferenceConvertModelToDomain preferenceConvertModelToDomain;

    @RequestMapping(value = "private/preferences/view")
    public String viewPreference(Model model, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        preferenceConvertModelToDomain = (PreferenceConvertModelToDomain) ctx.getBean("preferenceConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        model.addAttribute("preferences", preferences);
        return "/private/preferences/view";
    }

    @RequestMapping(value = "private/preferences/edit")
    public String editPreference(Model model, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        preferenceConvertModelToDomain = (PreferenceConvertModelToDomain) ctx.getBean("preferenceConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        model.addAttribute("preferences", preferences);
        model.addAttribute("measuringUnits", MeasuringUnit.values());
        return "/private/preferences/edit";
    }

    @RequestMapping(value = "private/preferences/update")
    public String updateExercise(Model model, @ModelAttribute("exercise") PreferenceModel preferenceModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        preferenceConvertModelToDomain = (PreferenceConvertModelToDomain) ctx.getBean("preferenceConvertModelToDomain");

        String userName = principal.getName();
        Preferences tempPreferences = preferenceConvertModelToDomain.convertToPreference(preferenceModel);
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        preferences.setMeasuringUnit(tempPreferences.getMeasuringUnit());
        preferences.setRestTimeInSeconds(tempPreferences.getRestTimeInSeconds());
        personService.updatePerson(currentPerson);

        model.addAttribute("preferences", preferences);
        return "/private/preferences/view";
    }
}
