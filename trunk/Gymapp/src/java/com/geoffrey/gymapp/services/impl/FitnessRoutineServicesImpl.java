/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.domain.RoutineItem;
import com.geoffrey.gymapp.services.FitnessRoutineServices;
import com.geoffrey.gymapp.services.crud.FitnessRoutineCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("fitnessRoutineService")
public class FitnessRoutineServicesImpl implements FitnessRoutineServices {
    
    @Autowired
    private FitnessRoutineCrudService fitnessRoutineCrudService;
    
    @Override
    public void updateFitnessRoutine(FitnessRoutine fitnessRoutine) {
        FitnessRoutine currentFitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutine.getId());
        currentFitnessRoutine.setFitnessLevel(fitnessRoutine.getFitnessLevel());
        currentFitnessRoutine.setName(fitnessRoutine.getName());
        currentFitnessRoutine.setRoutineType(fitnessRoutine.getRoutineType());
        
        List<RoutineItem> fitnessRoutineItems = currentFitnessRoutine.getRoutineItems();
        List<RoutineItem> items = fitnessRoutine.getRoutineItems();
        List<RoutineItem> deleteItems = new ArrayList<RoutineItem>();
        if (!items.equals(fitnessRoutineItems)) {
            for (RoutineItem fitnessRoutineItem : fitnessRoutineItems) {
                Workout workout = fitnessRoutineItem.getWorkout();
                for (RoutineItem item : items) {
                    Workout tempWorkout = item.getWorkout();
                    if (tempWorkout.getId() == workout.getId()) {
                        deleteItems.add(item);
                    }
                }
            }
            for (RoutineItem fitnessRoutineItem : deleteItems) {
                items.remove(fitnessRoutineItem);
            }
            for (RoutineItem fitnessRoutineItem : items) {
                fitnessRoutineItems.add(fitnessRoutineItem);
            }
        }
        fitnessRoutineCrudService.merge(currentFitnessRoutine);
    }
    
    @Override
    public List<FitnessRoutine> getFitnessRoutines() {
        List<FitnessRoutine> fitnessRoutines = fitnessRoutineCrudService.findAll();
        
        return fitnessRoutines;
    }
    
    @Override
    public void addFitnessRoutine(FitnessRoutine fitnessRoutine) {
        fitnessRoutineCrudService.persist(fitnessRoutine);
    }
    
    @Override
    public FitnessRoutine getFitnessRoutineByID(long id) {
        return fitnessRoutineCrudService.findById(id);
    }
    
    @Override
    public void deleteFitnessRoutine(long id) {
        fitnessRoutineCrudService.removeById(id);
    }
}
