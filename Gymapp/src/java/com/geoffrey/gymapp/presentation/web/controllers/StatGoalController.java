/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.BodyStatGoalModel;
import com.geoffrey.gymapp.services.BodyStatGoalConvertModelToDomain;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geoffrey
 */
@Controller
public class StatGoalController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private BodyStatGoalConvertModelToDomain bodyStatGoalConvertModelToDomain;
    private ExerciseServices exerciseService;

    @RequestMapping(value = "private/goal/body/save", method = RequestMethod.POST)
    public String saveExercise(Model model, @ModelAttribute("exercise") BodyStatGoalModel bodyStatGoalModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        bodyStatGoalConvertModelToDomain = (BodyStatGoalConvertModelToDomain) ctx.getBean("bodyStatGoalConvertModelToDomain");

        String userName = principal.getName();
        BodyStatGoal bodyStatGoal = bodyStatGoalConvertModelToDomain.convertToBodyStatGoal(bodyStatGoalModel);
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<BodyStatGoal> bodyStatGoals = currentPerson.getBodyStatGoals();
        bodyStatGoals.add(bodyStatGoal);
        personService.updatePerson(currentPerson);
        
        return "/private/goal/all";
    }

    @RequestMapping(value = "private/goal/body/edit")
    public String editExercise(Model model, @RequestParam("bodyStatGoalID") long bodyStatGoalId, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        bodyStatGoalConvertModelToDomain = (BodyStatGoalConvertModelToDomain) ctx.getBean("bodyStatGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<BodyStatGoal> bodyStatGoals = currentPerson.getBodyStatGoals();
        BodyStatGoal goal = null;
        for (BodyStatGoal bodyStatGoal : bodyStatGoals) {
            if (bodyStatGoal.getId() == bodyStatGoalId) {
                goal = bodyStatGoal;
                break;
            }
        }
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        model.addAttribute("bodyStatGoal", goal);
        return "private/goal/exercise/edit";
    }

    @RequestMapping(value = "private/goal/body/update")
    public String updateExercise(Model model, @ModelAttribute("exercise") BodyStatGoalModel bodyStatGoalModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        bodyStatGoalConvertModelToDomain = (BodyStatGoalConvertModelToDomain) ctx.getBean("bodyStatGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<BodyStatGoal> bodyStatGoals = currentPerson.getBodyStatGoals();
        String goalID = bodyStatGoalModel.getId();
        long bodyStatGoalID= Long.parseLong(goalID);
        BodyStatGoal goal = bodyStatGoalConvertModelToDomain.convertToBodyStatGoal(bodyStatGoalModel);
        for (BodyStatGoal bodyStatGoal : bodyStatGoals) {
            
            if (bodyStatGoal.getId() == bodyStatGoalID) {
                bodyStatGoal.setStatGoal(goal.getStatGoal());
                bodyStatGoal.setStatGroup(goal.getStatGroup());
                break;
            }
        }
        personService.updatePerson(currentPerson);
        return "/private/goal/all";
    }

    @RequestMapping(value = "private/goal/body/delete")
    public String deleteExercise(Model model, @RequestParam("bodyStatGoalID") long bodyStatGoalId, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        bodyStatGoalConvertModelToDomain = (BodyStatGoalConvertModelToDomain) ctx.getBean("bodyStatGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<BodyStatGoal> bodyStatGoals = currentPerson.getBodyStatGoals();
        for (BodyStatGoal bodyStatGoal : bodyStatGoals) {
            if (bodyStatGoal.getId() == bodyStatGoalId) {
                bodyStatGoals.remove(bodyStatGoal);
                break;
            }
        }
        
        personService.updatePerson(currentPerson);
        return "/private/goal/all";
    }
}
