/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.domain.Person;

/**
 *
 * @author 211026298
 */
public interface AddGoalService {
    public void addBodyStatGoal(Person person, BodyStatGoal bodyStatGoal);
    public void addExerciseGoal(Person person, ExerciseGoal exerciseGoal);
}
