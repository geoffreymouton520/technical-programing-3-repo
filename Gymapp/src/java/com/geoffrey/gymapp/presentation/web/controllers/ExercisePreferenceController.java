/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.ExercisePreference;
import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.ExercisePreferenceModel;
import com.geoffrey.gymapp.services.ExercisePreferenceConvertModelToDomain;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.PersonService;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.security.Principal;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geoffrey
 */
@Controller
public class ExercisePreferenceController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private ExerciseServices exerciseService;
    private ExercisePreferenceConvertModelToDomain exercisePreferenceConvertModelToDomain;

    @RequestMapping(value = "private/preferences/exercise/add")
    public String addExercisePreference(Model model, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "/private/preferences/exercise/add";
    }
    
    @RequestMapping(value = "private/preferences/exercise/save")
    public String saveExercisePreference(Model model, @ModelAttribute("exercisePreferenceModel") ExercisePreferenceModel exercisePreferenceModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exercisePreferenceConvertModelToDomain = (ExercisePreferenceConvertModelToDomain) ctx.getBean("exercisePreferenceConvertModelToDomain");

        String userName = principal.getName();
        ExercisePreference tempExercisePreferences = exercisePreferenceConvertModelToDomain.convertToExercisePreference(exercisePreferenceModel);
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
        exercisePreferences.add(tempExercisePreferences);
        personService.updatePerson(currentPerson);
        model.addAttribute("exercisePreferences", exercisePreferences);
        return "/private/preferences/exercise/all";
    }
    @RequestMapping(value = "private/preferences/exercise/all")
    public String showExercisePreferences(Model model, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exercisePreferenceConvertModelToDomain = (ExercisePreferenceConvertModelToDomain) ctx.getBean("exercisePreferenceConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
        model.addAttribute("exercisePreferences", exercisePreferences);
        return "/private/preferences/exercise/all";
    }

    @RequestMapping(value = "private/preferences/exercise/edit")
    public String editExercisePreference(Model model, Principal principal,@RequestParam("exercisePreferenceID") long exercisePreferenceID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        exercisePreferenceConvertModelToDomain = (ExercisePreferenceConvertModelToDomain) ctx.getBean("exercisePreferenceConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
        ExercisePreference tempExercisePreference = null;
        for (ExercisePreference exercisePreference : exercisePreferences) {
            if (exercisePreference.getId() == exercisePreferenceID) {
                tempExercisePreference = exercisePreference;
            }
        }
        model.addAttribute("exercisePreference", tempExercisePreference);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "/private/preferences/exercise/edit";
    }

    @RequestMapping(value = "private/preferences/exercise/update")
    public String updateExercisePreference(Model model, @ModelAttribute("exercisePreferenceModel") ExercisePreferenceModel exercisePreferenceModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exercisePreferenceConvertModelToDomain = (ExercisePreferenceConvertModelToDomain) ctx.getBean("exercisePreferenceConvertModelToDomain");

        String userName = principal.getName();
        ExercisePreference tempExercisePreferences = exercisePreferenceConvertModelToDomain.convertToExercisePreference(exercisePreferenceModel);
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
        for (ExercisePreference exercisePreference : exercisePreferences) {
            if (exercisePreference.getId() == tempExercisePreferences.getId()) {
                exercisePreference.setExercise(tempExercisePreferences.getExercise());
                exercisePreference.setExerciseSets(tempExercisePreferences.getExerciseSets());
                exercisePreference.setRepitions(tempExercisePreferences.getRepitions());
                break;
            }
        }
        personService.updatePerson(currentPerson);
        model.addAttribute("exercisePreferences", exercisePreferences);
        return "/private/preferences/exercise/all";
    }
    @RequestMapping(value = "private/preferences/exercise/delete")
    public String deleteExercisePreference(Model model, Principal principal,@RequestParam("exercisePreferenceID") long exercisePreferenceID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exercisePreferenceConvertModelToDomain = (ExercisePreferenceConvertModelToDomain) ctx.getBean("exercisePreferenceConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        Preferences preferences = currentPerson.getPreferences();
        List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
        for (ExercisePreference exercisePreference : exercisePreferences) {
            if (exercisePreference.getId() == exercisePreferenceID) {
                exercisePreferences.remove(exercisePreference);
                break;
            }
        }
        personService.updatePerson(currentPerson);
        model.addAttribute("exercisePreferences", exercisePreferences);
        return "/private/preferences/exercise/all";
    }
}
