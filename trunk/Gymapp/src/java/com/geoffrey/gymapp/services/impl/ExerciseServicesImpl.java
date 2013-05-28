/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.services.ExerciseServices;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("exerciseService")
public class ExerciseServicesImpl implements ExerciseServices{

    @Autowired
    private ExerciseCrudService exerciseCrudService;
    
    @Override
    public void updateExercise(Exercise exercise) {
        Exercise currentExercise = exerciseCrudService.findById(exercise.getId());
        currentExercise.setCaloriesBurned(exercise.getCaloriesBurned());
        currentExercise.setMuscleGroup(exercise.getMuscleGroup());
        currentExercise.setDescription(exercise.getDescription());
        currentExercise.setEquipment(exercise.getEquipment());
        currentExercise.setInstructions(exercise.getInstructions());
        currentExercise.setName(exercise.getName());
        exerciseCrudService.merge(currentExercise);
    }

    @Override
    public List<Exercise> getExercises() {
        List<Exercise> exercises = exerciseCrudService.findAll();
        
        return exercises;
    }

    @Override
    public void addExercise(Exercise exercise) {
        exerciseCrudService.persist(exercise);
    }

    @Override
    public Exercise getExerciseByID(long id) {
        return exerciseCrudService.findById(id);
    }

    @Override
    public void deleteExercise(long id) {
        exerciseCrudService.removeById(id);
    }
    
    
    
}
