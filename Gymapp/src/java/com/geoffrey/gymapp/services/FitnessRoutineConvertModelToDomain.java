/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.presentation.web.model.FitnessRoutineModel;

/**
 *
 * @author geoffrey
 */
public interface FitnessRoutineConvertModelToDomain {

    public FitnessRoutine convertToFitnessRoutine(FitnessRoutineModel fitnessRoutineModel);
    
}
