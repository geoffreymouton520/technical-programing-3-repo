/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.exceptions.ExerciseNullExecption;
import com.geoffrey.gymapp.app.factory.ExerciseFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.services.AddExerciseService;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("addExerciseService")
public class AddExerciseServiceImpl implements AddExerciseService{

    @Autowired
    public ExerciseCrudService exerciseCrudService;
    
    @Override
    public Exercise addExercise(Map<String, String> exerciseValues, MuscleGroup muscleGroup, float caloriesBurned) {
        ExerciseFactory exerciseFactory = ExerciseFactory.getInstance();
        Exercise exercise = exerciseFactory.getExercise(exerciseValues, muscleGroup, caloriesBurned);
        exerciseCrudService.persist(exercise);
        return exercise;
    }
    
}
