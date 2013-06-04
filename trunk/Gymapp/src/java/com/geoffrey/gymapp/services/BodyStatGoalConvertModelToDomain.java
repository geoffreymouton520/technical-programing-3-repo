/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.presentation.web.model.BodyStatGoalModel;

/**
 *
 * @author geoffrey
 */
public interface BodyStatGoalConvertModelToDomain {

    public BodyStatGoal convertToBodyStatGoal(BodyStatGoalModel bodyStatGoalModel);
    
}
