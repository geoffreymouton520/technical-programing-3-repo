/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Address;
import com.geoffrey.gymapp.domain.ExercisePreference;

/**
 *
 * @author geoffrey
 */
public class ExercisePreferenceFactory {
    private static ExercisePreferenceFactory exercisePreferenceFactory;

    private ExercisePreferenceFactory() {
    }
    
    public static ExercisePreferenceFactory getInstance(){
        if (exercisePreferenceFactory == null) {
            exercisePreferenceFactory = new ExercisePreferenceFactory();
        }
        return exercisePreferenceFactory;
    }
    
    public ExercisePreference getExercisePreference(int exerciseSets, int repitions){
        ExercisePreference exercisePreference = new ExercisePreference();
       
        exercisePreference.setExerciseSet(exerciseSets);
        exercisePreference.setRepitions(repitions);
        return exercisePreference;
    }
}
