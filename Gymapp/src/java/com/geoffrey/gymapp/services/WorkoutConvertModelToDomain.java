/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.presentation.web.model.WorkoutModel;

/**
 *
 * @author geoffrey
 */
public interface WorkoutConvertModelToDomain {

    public Workout convertToWorkout(WorkoutModel workoutModel);
    
}
