/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.ExerciseGoal;

/**
 *
 * @author geoffrey
 */
public class ExerciseGoalFactory {
    private static ExerciseGoalFactory exerciseGoalFactory;

    private ExerciseGoalFactory() {
    }
    
    public static ExerciseGoalFactory getInstance(){
        if (exerciseGoalFactory == null) {
            exerciseGoalFactory = new ExerciseGoalFactory();
        }
        return exerciseGoalFactory;
    }
    
    public ExerciseGoal getExerciseGoal(String name, float weight, int exerciseSets){
        ExerciseGoal exerciseGoal = new ExerciseGoal();
       
        exerciseGoal.setName(name);
        exerciseGoal.setExerciseSet(exerciseSets);
        exerciseGoal.setWeight(weight);
        return exerciseGoal;
    }
}
