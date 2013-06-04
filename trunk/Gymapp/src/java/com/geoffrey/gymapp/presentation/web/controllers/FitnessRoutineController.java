/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.domain.RoutineItem;
import com.geoffrey.gymapp.domain.RoutineType;
import com.geoffrey.gymapp.presentation.web.model.FitnessRoutineModel;
import com.geoffrey.gymapp.services.WorkoutServices;
import com.geoffrey.gymapp.services.FitnessRoutineConvertModelToDomain;
import com.geoffrey.gymapp.services.FitnessRoutineServices;
import java.util.ArrayList;
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
public class FitnessRoutineController {

    private static ApplicationContext ctx;
    private FitnessRoutineServices fitnessRoutineService;
    private WorkoutServices workoutServices;
    private FitnessRoutineConvertModelToDomain fitnessRoutineConvertModelToDomain;

    @RequestMapping(value = "private/fitnessRoutine/add")
    public String addFitnessRoutine(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        workoutServices = (WorkoutServices) ctx.getBean("workoutService");
        List<Workout> workouts = workoutServices.getWorkouts();
        model.addAttribute("workouts", workouts);
        model.addAttribute("fitnessLevels", FitnessLevel.values());
        model.addAttribute("routineTypes", RoutineType.values());
        return "private/fitnessRoutine/add";
    }

    @RequestMapping(value = "private/fitnessRoutine/save", method = RequestMethod.POST)
    public String saveFitnessRoutine(Model model, @ModelAttribute("fitnessRoutine") FitnessRoutineModel fitnessRoutineModel) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        fitnessRoutineConvertModelToDomain = (FitnessRoutineConvertModelToDomain) ctx.getBean("fitnessRoutineConvertModelToDomain");

        FitnessRoutine fitnessRoutine = fitnessRoutineConvertModelToDomain.convertToFitnessRoutine(fitnessRoutineModel);

        fitnessRoutineService.addFitnessRoutine(fitnessRoutine);

        List<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines();
        model.addAttribute("fitnessRoutines", fitnessRoutines);
        return "/private/fitnessRoutine/all";
    }

    @RequestMapping(value = "private/fitnessRoutine/all")
    public String showFitnessRoutines(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        List<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines();
        model.addAttribute("fitnessRoutines", fitnessRoutines);
        return "private/fitnessRoutine/all";
    }

    @RequestMapping(value = "private/fitnessRoutine/edit")
    public String editFitnessRoutine(Model model, @RequestParam("fitnessRoutineID") long fitnessRoutineID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        workoutServices = (WorkoutServices) ctx.getBean("workoutService");
        
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutineByID(fitnessRoutineID);
        List<Workout> workouts = workoutServices.getWorkouts();
        model.addAttribute("fitnessRoutine", fitnessRoutine);
        model.addAttribute("workouts", workouts);
        model.addAttribute("routineTypes", RoutineType.values());
        model.addAttribute("fitnessLevels", FitnessLevel.values());
        return "/private/fitnessRoutine/edit";
    }

    @RequestMapping(value = "private/fitnessRoutine/update")
    public String updateFitnessRoutine(Model model, @ModelAttribute("fitnessRoutine") FitnessRoutineModel fitnessRoutineModel) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        fitnessRoutineConvertModelToDomain = (FitnessRoutineConvertModelToDomain) ctx.getBean("fitnessRoutineConvertModelToDomain");

        FitnessRoutine fitnessRoutine = fitnessRoutineConvertModelToDomain.convertToFitnessRoutine(fitnessRoutineModel);
        fitnessRoutine.setId(Long.parseLong(fitnessRoutineModel.getId()));
        fitnessRoutineService.updateFitnessRoutine(fitnessRoutine);

        List<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines();
        model.addAttribute("fitnessRoutines", fitnessRoutines);
        return "private/fitnessRoutine/all";
    }

    @RequestMapping(value = "private/fitnessRoutine/delete")
    public String deleteWorkout(Model model, @RequestParam("fitnessRoutineID") long fitnessRoutineID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        fitnessRoutineConvertModelToDomain = (FitnessRoutineConvertModelToDomain) ctx.getBean("fitnessRoutineConvertModelToDomain");

        fitnessRoutineService.deleteFitnessRoutine(fitnessRoutineID);

        List<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines();
        model.addAttribute("fitnessRoutines", fitnessRoutines);
        return "private/fitnessRoutine/all";
    }
    
    @RequestMapping(value = "private/fitnessRoutine/view")
    public String showWorkouts(Model model, @RequestParam("fitnessRoutineID") long fitnessRoutineID){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        fitnessRoutineService = (FitnessRoutineServices) ctx.getBean("fitnessRoutineService");
        workoutServices = (WorkoutServices) ctx.getBean("workoutService");
        
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutineByID(fitnessRoutineID);
        List<RoutineItem> fitnessRoutineItems = fitnessRoutine.getRoutineItems();
        List<Workout> workouts = new ArrayList<Workout>();
        for (RoutineItem fitnessRoutineItem : fitnessRoutineItems) {
            workouts.add(fitnessRoutineItem.getWorkout());
        }
        model.addAttribute("workouts", workouts);
        return "private/workout/all";
    }
}
