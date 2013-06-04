/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.ExerciseGoalModel;
import com.geoffrey.gymapp.services.ExerciseGoalConvertModelToDomain;
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
public class ExerciseGoalController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private ExerciseGoalConvertModelToDomain exerciseGoalConvertModelToDomain;
    private ExerciseServices exerciseService;

    @RequestMapping(value = "private/goal/exercise/save", method = RequestMethod.POST)
    public String saveExercise(Model model, @ModelAttribute("exercise") ExerciseGoalModel exerciseGoalModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exerciseGoalConvertModelToDomain = (ExerciseGoalConvertModelToDomain) ctx.getBean("exerciseGoalConvertModelToDomain");

        String userName = principal.getName();
        ExerciseGoal exerciseGoal = exerciseGoalConvertModelToDomain.convertToExerciseGoal(exerciseGoalModel);
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<ExerciseGoal> exerciseGoals = currentPerson.getExerciseGoals();
        exerciseGoals.add(exerciseGoal);
        personService.updatePerson(currentPerson);
        
        return "/private/goal/all";
    }

    @RequestMapping(value = "private/goal/exercise/edit")
    public String editExercise(Model model, @RequestParam("exerciseGoalID") long exerciseGoalId, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exerciseGoalConvertModelToDomain = (ExerciseGoalConvertModelToDomain) ctx.getBean("exerciseGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<ExerciseGoal> exerciseGoals = currentPerson.getExerciseGoals();
        ExerciseGoal goal = null;
        for (ExerciseGoal exerciseGoal : exerciseGoals) {
            if (exerciseGoal.getId() == exerciseGoalId) {
                goal = exerciseGoal;
                break;
            }
        }
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        model.addAttribute("exerciseGoal", goal);
        return "private/goal/exercise/edit";
    }

    @RequestMapping(value = "private/goal/exercise/update")
    public String updateExercise(Model model, @ModelAttribute("exercise") ExerciseGoalModel exerciseGoalModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exerciseGoalConvertModelToDomain = (ExerciseGoalConvertModelToDomain) ctx.getBean("exerciseGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<ExerciseGoal> exerciseGoals = currentPerson.getExerciseGoals();
        String goalID = exerciseGoalModel.getId();
        long exerciseGoalID= Long.parseLong(goalID);
        ExerciseGoal goal = exerciseGoalConvertModelToDomain.convertToExerciseGoal(exerciseGoalModel);
        for (ExerciseGoal exerciseGoal : exerciseGoals) {
            
            if (exerciseGoal.getId() == exerciseGoalID) {
                exerciseGoal.setExercise(goal.getExercise());
                exerciseGoal.setExerciseSets(goal.getExerciseSets());
                exerciseGoal.setWeight(goal.getWeight());
                break;
            }
        }
        personService.updatePerson(currentPerson);
        return "/private/goal/all";
    }

    @RequestMapping(value = "private/goal/exercise/delete")
    public String deleteExercise(Model model, @RequestParam("exerciseGoalID") long exerciseGoalId, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        exerciseGoalConvertModelToDomain = (ExerciseGoalConvertModelToDomain) ctx.getBean("exerciseGoalConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<ExerciseGoal> exerciseGoals = currentPerson.getExerciseGoals();
        for (ExerciseGoal exerciseGoal : exerciseGoals) {
            if (exerciseGoal.getId() == exerciseGoalId) {
                exerciseGoals.remove(exerciseGoal);
                break;
            }
        }
        
        personService.updatePerson(currentPerson);
        return "/private/goal/all";
    }
}
