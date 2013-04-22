/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.domain.RoutineType;

/**
 *
 * @author geoffrey
 */
public class FitnessRoutineFactory {
    private static FitnessRoutineFactory fitnessRoutineFactory;

    private FitnessRoutineFactory() {
    }
    
    public static FitnessRoutineFactory getInstance(){
        if (fitnessRoutineFactory == null) {
            fitnessRoutineFactory = new FitnessRoutineFactory();
        }
        return fitnessRoutineFactory;
    }
    
    public FitnessRoutine getFitnessRoutine(FitnessLevel fitnessLevel, String name, RoutineType routineType){
        FitnessRoutine fitnessRoutine = new FitnessRoutine();
       
        fitnessRoutine.setFitnessLevel(fitnessLevel);
        fitnessRoutine.setName(name);
        fitnessRoutine.setRoutineType(routineType);
        return fitnessRoutine;
    }
}
