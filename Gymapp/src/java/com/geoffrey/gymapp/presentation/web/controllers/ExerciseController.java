/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.presentation.web.model.ExerciseModel;
import com.geoffrey.gymapp.services.ExerciseConvertModelToDomain;
import com.geoffrey.gymapp.services.ExerciseServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    @Qualifier("exerciseService")
    private ExerciseServices exerciseService;
    
    @Autowired
    @Qualifier("exerciseConvertModelToDomain")
    private ExerciseConvertModelToDomain exerciseConvertModelToDomain;
    
    @RequestMapping(value="exerciseadd")
    public String addExercise() {
        return "exercise/add";
    }
    
    @RequestMapping(value = "exercisesave", method = RequestMethod.POST)
    public String saveExercise(Model model, @ModelAttribute("exercise") ExerciseModel exerciseModel){
        Exercise exercise = exerciseConvertModelToDomain.convertToExercise(exerciseModel);
        exerciseService.addExercise(exercise);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "exercise/all";
    }
    
    @RequestMapping(value = "exerciseall")
    public String showExercises(Model model){
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "exercise/all";
    }
    
    @RequestMapping(value = "exerciseedit")
    public String editExercise(Model model,@RequestParam("exerciseID") long exerciseId){
        Exercise exercise = exerciseService.getExerciseByID(exerciseId);
        model.addAttribute("exercise", exercise);
        return "exercise/edit";
    }
    
    
    @RequestMapping(value = "exerciseupdate")
    public String updateExercise(Model model,@ModelAttribute("exercise") ExerciseModel exerciseModel){
        Exercise exercise = exerciseConvertModelToDomain.convertToExercise(exerciseModel);
        exerciseService.updateExercise(exercise);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "exercise/all";
    }
    
    @RequestMapping(value = "exercisedelete")
    public String deleteExercise(Model model,@RequestParam("exerciseID") long exerciseId){
        exerciseService.deleteExercise(exerciseId);
        
        List<Exercise> exercises = exerciseService.getExercises();
        model.addAttribute("exercises", exercises);
        return "exercise/all";
    }
}
