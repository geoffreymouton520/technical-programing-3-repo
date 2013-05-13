/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.presentation.web.model.ExerciseModel;
import com.geoffrey.gymapp.services.ExerciseConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
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
public class ExerciseController {
    private ApplicationContext ctx;
    private ExerciseCrudService exerciseCrudService;
    private ExerciseConvertModelToDomain exerciseConvertModelToDomain;
    
    
    
    
    @RequestMapping(value="/addExercise")
    public String addExercise() {
        return "exercise";
        //return new ModelAndView("exercise", "command", new Exercise());
    }
    
    @RequestMapping(value = "/saveExercise", method = RequestMethod.POST)
    public String saveExercise(Model model, @ModelAttribute("exercise") ExerciseModel exerciseModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        exerciseConvertModelToDomain = (ExerciseConvertModelToDomain) ctx.getBean("exerciseConvertModelToDomain");
        
        Exercise exercise = exerciseConvertModelToDomain.convertToExercise(exerciseModel);
        exerciseCrudService.persist(exercise);
        return "exercises";
    }
    
    @RequestMapping(value = "/exercises")
    public String showExercises(Model model){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        exerciseConvertModelToDomain = (ExerciseConvertModelToDomain) ctx.getBean("exerciseConvertModelToDomain");
        
        List<Exercise> exercises = exerciseCrudService.findAll();
        model.addAttribute("exercises", exercises);
        return "exercises";
    }
    
    @RequestMapping(value = "/editExercise")
    public String editExercise(Model model,@RequestParam("exercise") long exerciseId){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        exerciseConvertModelToDomain = (ExerciseConvertModelToDomain) ctx.getBean("exerciseConvertModelToDomain");
        
        Exercise exercise = exerciseCrudService.findById(exerciseId);
        model.addAttribute("exercise", exercise);
        return "editExercise";
    }
    
    
}
