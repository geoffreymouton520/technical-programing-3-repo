/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.StatGroup;

/**
 *
 * @author geoffrey
 */
public class BodyStatGoalFactory {
    private static BodyStatGoalFactory bodyStatGoalFactory;

    private BodyStatGoalFactory() {
    }
    
    public static BodyStatGoalFactory getInstance(){
        if (bodyStatGoalFactory == null) {
            bodyStatGoalFactory = new BodyStatGoalFactory();
        }
        return bodyStatGoalFactory;
    }
    
    public BodyStatGoal getBodyStatGoal(String name, float statGoal, StatGroup statGroup){
        BodyStatGoal bodyStatGoal = new BodyStatGoal();
       
        bodyStatGoal.setName(name);
        bodyStatGoal.setStatGoal(statGoal);
        bodyStatGoal.setStatGroup(statGroup);
        return bodyStatGoal;
    }
}
