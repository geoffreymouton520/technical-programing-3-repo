/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.FitnessRoutine;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public interface FitnessRoutineServices {
    public void updateFitnessRoutine(FitnessRoutine fitnessRoutine);
    
    public List<FitnessRoutine> getFitnessRoutines();
    
    public void addFitnessRoutine(FitnessRoutine fitnessRoutine);
    
    public FitnessRoutine getFitnessRoutineByID(long id);
    
    public void deleteFitnessRoutine(long id);
}
