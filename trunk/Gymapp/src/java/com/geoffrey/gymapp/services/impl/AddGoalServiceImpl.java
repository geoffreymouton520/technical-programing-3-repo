/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.ExerciseGoal;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.services.AddGoalService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211026298
 */
@Service("addGoalService")
public class AddGoalServiceImpl implements AddGoalService{

    @Override
    public void addBodyStatGoal(Person person, BodyStatGoal bodyStatGoal) {
        List<BodyStatGoal> bodyStatGoals = person.getBodyStatGoals();
        bodyStatGoals.add(bodyStatGoal);
        person.setBodyStatGoals(bodyStatGoals);
    }

    @Override
    public void addExerciseGoal(Person person, ExerciseGoal exerciseGoal) {
        List<ExerciseGoal> exerciseGoals = person.getExerciseGoals();
        exerciseGoals.add(exerciseGoal);
        person.setExerciseGoals(exerciseGoals);
    }
    
}
