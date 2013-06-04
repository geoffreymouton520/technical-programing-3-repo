/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.WorkoutItem;
import com.geoffrey.gymapp.presentation.web.model.WorkoutModel;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.WorkoutConvertModelToDomain;
import com.geoffrey.gymapp.services.WorkoutServices;
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
public class WorkoutController {

    private static ApplicationContext ctx;
    private WorkoutServices workoutService;
    private ExerciseServices exerciseServices;
    private WorkoutConvertModelToDomain workoutConvertModelToDomain;

    @RequestMapping(value = "private/workout/add")
    public String addWorkout(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        exerciseServices = (ExerciseServices) ctx.getBean("exerciseService");
        List<Exercise> exercises = exerciseServices.getExercises();
        model.addAttribute("exercises", exercises);
        model.addAttribute("fitnessLevels", FitnessLevel.values());
        return "private/workout/add";
    }

    @RequestMapping(value = "private/workout/save", method = RequestMethod.POST)
    public String saveWorkout(Model model, @ModelAttribute("workout") WorkoutModel workoutModel) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        workoutConvertModelToDomain = (WorkoutConvertModelToDomain) ctx.getBean("workoutConvertModelToDomain");

        Workout workout = workoutConvertModelToDomain.convertToWorkout(workoutModel);

        workoutService.addWorkout(workout);

        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("workouts", workouts);
        return "/private/workout/all";
    }

    @RequestMapping(value = "private/workout/all")
    public String showWorkouts(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("workouts", workouts);
        return "private/workout/all";
    }

    @RequestMapping(value = "private/workout/edit")
    public String editWorkout(Model model, @RequestParam("workoutID") long workoutID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        exerciseServices = (ExerciseServices) ctx.getBean("exerciseService");
        
        Workout workout = workoutService.getWorkoutByID(workoutID);
        List<Exercise> exercises = exerciseServices.getExercises();
        model.addAttribute("workout", workout);
        model.addAttribute("exercises", exercises);
        model.addAttribute("fitnessLevels", FitnessLevel.values());
        return "/private/workout/edit";
    }

    @RequestMapping(value = "private/workout/update")
    public String updateWorkout(Model model, @ModelAttribute("workout") WorkoutModel workoutModel) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        workoutConvertModelToDomain = (WorkoutConvertModelToDomain) ctx.getBean("workoutConvertModelToDomain");

        Workout workout = workoutConvertModelToDomain.convertToWorkout(workoutModel);
        workout.setId(Long.parseLong(workoutModel.getId()));
        workoutService.updateWorkout(workout);

        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("workouts", workouts);
        return "private/workout/all";
    }

    @RequestMapping(value = "private/workout/delete")
    public String deleteExercise(Model model, @RequestParam("workoutID") long workoutID) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        workoutConvertModelToDomain = (WorkoutConvertModelToDomain) ctx.getBean("workoutConvertModelToDomain");

        workoutService.deleteWorkout(workoutID);

        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("workouts", workouts);
        return "private/workout/all";
    }
    
    @RequestMapping(value = "private/workout/view")
    public String showExercises(Model model, @RequestParam("workoutID") long workoutID){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        workoutService = (WorkoutServices) ctx.getBean("workoutService");
        exerciseServices = (ExerciseServices) ctx.getBean("exerciseService");
        
        Workout workout = workoutService.getWorkoutByID(workoutID);
        List<WorkoutItem> workoutItems = workout.getWorkoutItems();
        List<Exercise> exercises = new ArrayList<Exercise>();
        for (WorkoutItem workoutItem : workoutItems) {
            exercises.add(workoutItem.getExercise());
        }
        model.addAttribute("exercises", exercises);
        return "private/exercise/all";
    }
}
