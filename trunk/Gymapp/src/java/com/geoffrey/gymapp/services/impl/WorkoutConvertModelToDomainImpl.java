/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.WorkoutFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.WorkoutItem;
import com.geoffrey.gymapp.presentation.web.model.WorkoutModel;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.WorkoutConvertModelToDomain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("workoutConvertModelToDomain")
public class WorkoutConvertModelToDomainImpl implements WorkoutConvertModelToDomain {

    @Autowired
    private ExerciseServices exerciseServices;

    @Override
    public Workout convertToWorkout(WorkoutModel workoutModel) {
        List<WorkoutItem> workoutItems = new ArrayList<WorkoutItem>();
        
        FitnessLevel fitnessLevel = FitnessLevel.valueOf(workoutModel.getFitnessLevel());
        float caloriesBurned = Float.parseFloat(workoutModel.getTotalCaloriesBurned());
        int time = Integer.parseInt(workoutModel.getWorkoutDurationInMins());
        
        List<String> exerciseIDs = workoutModel.getWorkoutItemsId();
        for (String exerciseID : exerciseIDs) {
            long id = Long.parseLong(exerciseID);
            Exercise temp = exerciseServices.getExerciseByID(id);
            WorkoutItem workoutItem = new WorkoutItem();
            workoutItem.setExercise(temp);
            workoutItems.add(workoutItem);
        }

        WorkoutFactory workoutFactory = WorkoutFactory.getInstance();
        Workout workout = workoutFactory.getWorkout(fitnessLevel, caloriesBurned, time);
        workout.setWorkoutItems(workoutItems);
        return workout;
    }
}
