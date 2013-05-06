/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.ExercisePreference;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.services.ChangePreferencesService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("changePreferencesService")
public class ChangePreferencesServiceImpl implements ChangePreferencesService{

    @Override
    public void changeMainPrefernce(Person person, Preferences preferences) {
        Preferences oldPreferences = person.getPreferences();
        oldPreferences.setMeasuringUnit(preferences.getMeasuringUnit());
        oldPreferences.setRestTimeInSeconds(preferences.getRestTimeInSeconds());
    }

    @Override
    public void changeExercisePreference(Person person, ExercisePreference exercisePreference) {
         Preferences preferences = person.getPreferences();
         
         Exercise exercise = exercisePreference.getExercise();
         String exerciseName = exercise.getName();
         
         List<ExercisePreference> exercisePreferences = preferences.getExercisePreferences();
         for (int i = 0; i < exercisePreferences.size(); i++) {
             ExercisePreference tempExercisePrefernce = exercisePreferences.get(i);
             Exercise tempExercise = tempExercisePrefernce.getExercise();
             String tempExerciseName = tempExercise.getName();
             
             if (exerciseName.equals(tempExerciseName)) {
                 exercisePreferences.remove(i);
                 exercisePreferences.add(exercisePreference);
                 break;
             }
        }
    }
    
}
