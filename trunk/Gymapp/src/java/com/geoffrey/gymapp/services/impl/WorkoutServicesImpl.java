/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.WorkoutItem;
import com.geoffrey.gymapp.services.WorkoutServices;
import com.geoffrey.gymapp.services.crud.WorkoutCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("workoutService")
public class WorkoutServicesImpl implements WorkoutServices {
    
    @Autowired
    private WorkoutCrudService workoutCrudService;
    
    @Override
    public void updateWorkout(Workout workout) {
        Workout currentWorkout = workoutCrudService.findById(workout.getId());
        currentWorkout.setTotalCaloriesBurned(workout.getTotalCaloriesBurned());
        currentWorkout.setFitnessLevel(workout.getFitnessLevel());
        currentWorkout.setWorkoutDurationInMins(workout.getWorkoutDurationInMins());
        //currentWorkout.setWorkoutItems(workout.getWorkoutItems());
        List<WorkoutItem> workoutItems = currentWorkout.getWorkoutItems();
        List<WorkoutItem> items = workout.getWorkoutItems();
        List<WorkoutItem> deleteItems = new ArrayList<WorkoutItem>();
        if (!items.equals(workoutItems)) {
            for (WorkoutItem workoutItem : workoutItems) {
                Exercise exercise = workoutItem.getExercise();
                for (WorkoutItem item : items) {
                    Exercise tempExercise = item.getExercise();
                    if (tempExercise.getId() == exercise.getId()) {
                        deleteItems.add(item);
                    }
                }
            }
            for (WorkoutItem workoutItem : deleteItems) {
                items.remove(workoutItem);
            }
            for (WorkoutItem workoutItem : items) {
                workoutItems.add(workoutItem);
            }
        }
        workoutCrudService.merge(currentWorkout);
    }
    
    @Override
    public List<Workout> getWorkouts() {
        List<Workout> workouts = workoutCrudService.findAll();
        
        return workouts;
    }
    
    @Override
    public void addWorkout(Workout workout) {
        workoutCrudService.persist(workout);
    }
    
    @Override
    public Workout getWorkoutByID(long id) {
        return workoutCrudService.findById(id);
    }
    
    @Override
    public void deleteWorkout(long id) {
        workoutCrudService.removeById(id);
    }
}
