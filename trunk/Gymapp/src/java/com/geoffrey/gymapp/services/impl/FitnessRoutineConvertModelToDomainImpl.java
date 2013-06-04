/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.FitnessRoutineFactory;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.domain.RoutineItem;
import com.geoffrey.gymapp.domain.RoutineType;
import com.geoffrey.gymapp.presentation.web.model.FitnessRoutineModel;
import com.geoffrey.gymapp.services.WorkoutServices;
import com.geoffrey.gymapp.services.FitnessRoutineConvertModelToDomain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("fitnessRoutineConvertModelToDomain")
public class FitnessRoutineConvertModelToDomainImpl implements FitnessRoutineConvertModelToDomain {

    @Autowired
    private WorkoutServices workoutServices;

    @Override
    public FitnessRoutine convertToFitnessRoutine(FitnessRoutineModel fitnessRoutineModel) {
        List<RoutineItem> fitnessRoutineItems = new ArrayList<RoutineItem>();
        
        FitnessLevel fitnessLevel = FitnessLevel.valueOf(fitnessRoutineModel.getFitnessLevel());
        RoutineType routineType = RoutineType.valueOf(fitnessRoutineModel.getRoutineType());
        String name = fitnessRoutineModel.getName();
        
        List<String> workoutIDs = fitnessRoutineModel.getWorkoutIDs();
        for (String workoutID : workoutIDs) {
            long id = Long.parseLong(workoutID);
            Workout temp = workoutServices.getWorkoutByID(id);
            RoutineItem fitnessRoutineItem = new RoutineItem();
            fitnessRoutineItem.setWorkout(temp);
            fitnessRoutineItems.add(fitnessRoutineItem);
        }

        FitnessRoutineFactory fitnessRoutineFactory = FitnessRoutineFactory.getInstance();
        FitnessRoutine fitnessRoutine = fitnessRoutineFactory.getFitnessRoutine(fitnessLevel, name, routineType);
        fitnessRoutine.setRoutineItems(fitnessRoutineItems);
        return fitnessRoutine;
    }
}
