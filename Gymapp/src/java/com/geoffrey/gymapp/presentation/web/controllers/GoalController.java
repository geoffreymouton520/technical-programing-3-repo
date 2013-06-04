/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.StatGroup;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.PersonService;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.security.Principal;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geoffrey
 */
@Controller
public class GoalController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private ExerciseServices exerciseService;

    @RequestMapping(value = "private/goal/add")
    public String addGoal(Model model) {
        return "private/goal/add";
    }

    @RequestMapping(value = "private/goal/addselect")
    public String selectAddGoal(Model model, @RequestParam("goal") String goalType) {
        if (goalType.equals("body")) {
            model.addAttribute("statsGroups", StatGroup.values());
            return "private/goal/body/add";
        } else {
            ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
            exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
            List<Exercise> exercises = exerciseService.getExercises();
            model.addAttribute("exercises", exercises);
            return "private/goal/exercise/add";
        }
    }

    @RequestMapping(value = "private/goal/all")
    public String showGoals(Model model) {
        return "private/goal/all";
    }

    @RequestMapping(value = "private/goal/allselect", method = RequestMethod.POST)
    public String selectShowGoals(Model model, @RequestParam("goal") String goalType, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        if (goalType.equals("body")) {
            String userName = principal.getName();
            Users tempUser = userCrudService.getByPropertyName("userName", userName);
            Person tempPerson = tempUser.getPerson();
            Long personID = tempPerson.getId();
            
            Person currentPerson = personService.getPersonByID(personID);
            List<BodyStatGoal> bodyStatGoals = currentPerson.getBodyStatGoals();
            model.addAttribute("bodyStatGoals", bodyStatGoals);
            return "private/goal/body/all";
        } else {
            String userName = principal.getName();
            Users tempUser = userCrudService.getByPropertyName("userName", userName);
            Person tempPerson = tempUser.getPerson();
            Long personID = tempPerson.getId();
            
            Person currentPerson = personService.getPersonByID(personID);
            List<ExerciseGoal> exerciseGoals = currentPerson.getExerciseGoals();
            model.addAttribute("exerciseGoals", exerciseGoals);
            return "private/goal/exercise/all";
        }
    }

    @RequestMapping(value = "private/goal/editselect", method = RequestMethod.POST)
    public String selectEditGoal(Model model, @RequestParam("goal") String goalType) {
        if (goalType.equals("body")) {
            return "private/goal/body/edit";
        } else {
            return "private/goal/exercise/edit";
        }
    }
}
