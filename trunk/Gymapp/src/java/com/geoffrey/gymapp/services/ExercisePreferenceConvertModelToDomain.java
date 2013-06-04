/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.ExercisePreference;
import com.geoffrey.gymapp.presentation.web.model.ExercisePreferenceModel;

/**
 *
 * @author geoffrey
 */
public interface ExercisePreferenceConvertModelToDomain {

    public ExercisePreference convertToExercisePreference(ExercisePreferenceModel exercisePreferenceModel);
    
}
