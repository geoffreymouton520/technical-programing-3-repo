/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.ExercisePreference;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.domain.Preferences;

/**
 *
 * @author 211026298
 */
public interface ChangePreferencesService {
    public void changeMainPrefernce(Person person, Preferences preferences);
    public void changeExercisePreference(Person person,ExercisePreference exercisePreference);
}
