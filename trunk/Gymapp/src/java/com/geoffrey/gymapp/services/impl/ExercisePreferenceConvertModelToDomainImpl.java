/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.ExercisePreferenceFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.ExercisePreference;
import com.geoffrey.gymapp.presentation.web.model.ExercisePreferenceModel;
import com.geoffrey.gymapp.services.ExercisePreferenceConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("exercisePreferenceConvertModelToDomain")
public class ExercisePreferenceConvertModelToDomainImpl implements ExercisePreferenceConvertModelToDomain{

    @Autowired
    private ExerciseCrudService exerciseCrudService;

    @Override
    public ExercisePreference convertToExercisePreference(ExercisePreferenceModel exercisePreferenceModel) {
        long exerciseID = Long.parseLong(exercisePreferenceModel.getExerciseID());
        Exercise currentExercise = exerciseCrudService.findById(exerciseID);
        int rep = Integer.parseInt(exercisePreferenceModel.getRepitions());
        int set = Integer.parseInt(exercisePreferenceModel.getExerciseSets());
        
        ExercisePreferenceFactory exercisePreferenceFactory = ExercisePreferenceFactory.getInstance();
        ExercisePreference exercisePreference = exercisePreferenceFactory.getExercisePreference(rep, set);
        exercisePreference.setExercise(currentExercise);
        return exercisePreference;
    }
    
}
