/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.presentation.web.model.ExerciseModel;
import com.geoffrey.gymapp.services.ExerciseConvertModelToDomain;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import com.geoffrey.gymapp.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class PreferenceController {
   /* private static ApplicationContext ctx;
    @Autowired
    @Qualifier("exerciseService")
    private ExerciseServices exerciseService;
    
    @Autowired
    @Qualifier("exerciseConvertModelToDomain")
    private ExerciseConvertModelToDomain exerciseConvertModelToDomain;
    
    @RequestMapping(value="private/exercise/add")
    public String addExercise(Model model) {
        model.addAttribute("muscleGroups", MuscleGroup.values());
        return "private/exercise/add";
    }
    
    @RequestMapping(value = "private/exercise/save", method = RequestMethod.POST)
    public String saveExercise(Model model, @ModelAttribute("exercise") ExerciseModel exerciseModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        exerciseConvertModelToDomain = (ExerciseConvertModelToDomain) ctx.getBean("exerciseConvertModelToDomain");
        
        Exercise exercise = exerciseConvertModelToDomain.convertToExercise(exerciseModel);
        exerciseService.addExercise(exercise);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "/private/exercise/all";
    }
    
    @RequestMapping(value = "private/exercise/all")
    public String showExercises(Model model){
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "private/exercise/all";
    }
    
    @RequestMapping(value = "private/exercise/edit")
    public String editExercise(Model model,@RequestParam("exerciseID") long exerciseId){
        Exercise exercise = exerciseService.getExerciseByID(exerciseId);
        model.addAttribute("exercise", exercise);
        model.addAttribute("muscleGroups", MuscleGroup.values());
        return "/private/exercise/edit";
    }
    
    
    @RequestMapping(value = "private/exercise/update")
    public String updateExercise(Model model,@ModelAttribute("exercise") ExerciseModel exerciseModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        exerciseConvertModelToDomain = (ExerciseConvertModelToDomain) ctx.getBean("exerciseConvertModelToDomain");
        
        Exercise exercise = exerciseConvertModelToDomain.convertToExercise(exerciseModel);
        exercise.setId(Long.parseLong(exerciseModel.getId()));
        exerciseService.updateExercise(exercise);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "/private/exercise/all";
    }
    
    @RequestMapping(value = "private/exercise/delete")
    public String deleteExercise(Model model,@RequestParam("exerciseID") long exerciseId){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        exerciseService = (ExerciseServices) ctx.getBean("exerciseService");
        
        exerciseService.deleteExercise(exerciseId);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "/private/exercise/all";
    }*/
}
