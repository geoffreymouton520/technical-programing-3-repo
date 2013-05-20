/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Exercise;
import java.util.List;

/**
 *
 * @author 211026298
 */
public interface ExerciseServices {
    public void updateExercise(Exercise exercise);
    
    public List<Exercise> getExercises();
    
    public void addExercise(Exercise exercise);
    
    public Exercise getExerciseByID(long id);
    
    public void deleteExercise(long id);
}
