/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.ExerciseGoalFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.presentation.web.model.ExerciseGoalModel;
import com.geoffrey.gymapp.services.ExerciseGoalConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("exerciseGoalConvertModelToDomain")
public class ExerciseGoalConvertModelToDomainImpl implements ExerciseGoalConvertModelToDomain{

    @Autowired
    private ExerciseCrudService exerciseCrudService;

    @Override
    public ExerciseGoal convertToExerciseGoal(ExerciseGoalModel exerciseGoalModel) {
        long exerciseID = Long.parseLong(exerciseGoalModel.getExerciseID());
        Exercise currentExercise = exerciseCrudService.findById(exerciseID);
        float weight = Float.parseFloat(exerciseGoalModel.getWeight());
        int set = Integer.parseInt(exerciseGoalModel.getExerciseSets());
        
        ExerciseGoalFactory exerciseGoalFactory = ExerciseGoalFactory.getInstance();
        ExerciseGoal exerciseGoal = exerciseGoalFactory.getExerciseGoal(weight, set);
        exerciseGoal.setExercise(currentExercise);
        return exerciseGoal;
    }
    
}
