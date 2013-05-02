/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.MuscleGroup;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class ExerciseFactory {
    private static ExerciseFactory exerciseFactory;

    private ExerciseFactory() {
    }
    
    public static ExerciseFactory getInstance(){
        if (exerciseFactory == null) {
            exerciseFactory = new ExerciseFactory();
        }
        return exerciseFactory;
    }
    
    public Exercise getExercise(Map<String,String> values, MuscleGroup muscleGroup, float caloriesBurned){
        Exercise exercise = new Exercise();
       
        exercise.setCaloriesBurned(caloriesBurned);
        exercise.setMuscleGroup(muscleGroup);
        exercise.setDescription(values.get("Description"));
        exercise.setEquipment(values.get("Equipment"));
        exercise.setInstructions(values.get("Instructions"));
        exercise.setName(values.get("Name"));
        return exercise;
    }
}
