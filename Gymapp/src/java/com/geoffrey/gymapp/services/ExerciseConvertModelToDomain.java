/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.presentation.web.model.ExerciseModel;

/**
 *
 * @author geoffrey
 */
public interface ExerciseConvertModelToDomain {
    public Exercise convertToExercise(ExerciseModel exerciseModel);
}
