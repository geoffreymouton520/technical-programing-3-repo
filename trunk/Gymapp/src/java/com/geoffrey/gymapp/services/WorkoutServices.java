/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Workout;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public interface WorkoutServices {
    public void updateWorkout(Workout workout);
    
    public List<Workout> getWorkouts();
    
    public void addWorkout(Workout workout);
    
    public Workout getWorkoutByID(long id);
    
    public void deleteWorkout(long id);
}
