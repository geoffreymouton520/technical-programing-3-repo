/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.Statistic;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.presentation.web.model.StatisticModel;
import com.geoffrey.gymapp.services.ExerciseGoalConvertModelToDomain;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.StatisticConvertModelToDomain;
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

/**
 *
 * @author geoffrey
 */
@Controller
public class StatisticsController {

    private static ApplicationContext ctx;
    private UserCrudService userCrudService;
    private PersonService personService;
    private ExerciseServices exerciseService;
    private StatisticConvertModelToDomain statisticConvertModelToDomain;

    @RequestMapping(value = "private/statistics/add")
    public String addStatistic(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "private/statistics/add";
    }

    @RequestMapping(value = "private/statistics/save", method = RequestMethod.POST)
    public String saveStatistic(Model model, @ModelAttribute("statistic") StatisticModel statisticModel, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        statisticConvertModelToDomain = (StatisticConvertModelToDomain) ctx.getBean("statisticConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<Statistic> statistics = currentPerson.getStatistics();

        Statistic statistic = statisticConvertModelToDomain.convertToStatistic(statisticModel);
        statistics.add(statistic);
        personService.updatePerson(currentPerson);

        model.addAttribute("statistics", statistics);
        return "/private/statistics/all";
    }

    @RequestMapping(value = "private/statistics/all")
    public String showStatistics(Model model, Principal principal) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        userCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        personService = (PersonService) ctx.getBean("personService");
        statisticConvertModelToDomain = (StatisticConvertModelToDomain) ctx.getBean("statisticConvertModelToDomain");

        String userName = principal.getName();
        Users tempUser = userCrudService.getByPropertyName("userName", userName);
        Person tempPerson = tempUser.getPerson();

        Long personID = tempPerson.getId();
        Person currentPerson = personService.getPersonByID(personID);
        List<Statistic> statistics = currentPerson.getStatistics();

        model.addAttribute("statistics", statistics);
        return "private/statistics/all";
    }
}
