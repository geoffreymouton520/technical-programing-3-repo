/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.ExerciseFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.presentation.web.model.ExerciseModel;
import com.geoffrey.gymapp.services.ExerciseConvertModelToDomain;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("exerciseConvertModelToDomain")
public class ExerciseConvertModelToDomainImpl implements ExerciseConvertModelToDomain{

    @Override
    public Exercise convertToExercise(ExerciseModel exerciseModel) {
        Map<String,String> exerciseDetails = new HashMap<String,String>();
        exerciseDetails.put("Description", exerciseModel.getDescription());
        exerciseDetails.put("Equipment", exerciseModel.getEquipment());
        exerciseDetails.put("Instructions", exerciseModel.getInstructions());
        exerciseDetails.put("Name", exerciseModel.getName());
        MuscleGroup muscleGroup = MuscleGroup.valueOf(exerciseModel.getMuscleGroup());
        float caloriesBurned = Float.parseFloat(exerciseModel.getCaloriesBurned());
        ExerciseFactory exerciseFactory = ExerciseFactory.getInstance();
        Exercise exercise = exerciseFactory.getExercise(exerciseDetails, muscleGroup, caloriesBurned);
        return exercise;
    }
    
}
