/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.presentation.web.model.ExerciseGoalModel;

/**
 *
 * @author geoffrey
 */
public interface ExerciseGoalConvertModelToDomain {

    public ExerciseGoal convertToExerciseGoal(ExerciseGoalModel exerciseGoalModel);
    
}
