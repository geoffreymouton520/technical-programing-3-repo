/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.Workout;

/**
 *
 * @author geoffrey
 */
public class WorkoutFactory {
    private static WorkoutFactory workoutFactory;

    private WorkoutFactory() {
    }
    
    public static WorkoutFactory getInstance(){
        if (workoutFactory == null) {
            workoutFactory = new WorkoutFactory();
        }
        return workoutFactory;
    }
    
    public Workout getWorkout(FitnessLevel fitnessLevel, float totalCaloriesBurned, int workoutDurationInMins){
        Workout workout = new Workout();
       
        workout.setFitnessLevel(fitnessLevel);
        workout.setTotalCaloriesBurned(totalCaloriesBurned);
        workout.setWorkoutDurationInMins(workoutDurationInMins);
        return workout;
    }
}
