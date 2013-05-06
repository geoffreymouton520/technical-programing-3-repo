/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.MuscleGroup;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public interface AddExerciseService {
    public long addExercise(Map<String,String> exerciseValues, MuscleGroup muscleGroup, float caloriesBurned);
}
