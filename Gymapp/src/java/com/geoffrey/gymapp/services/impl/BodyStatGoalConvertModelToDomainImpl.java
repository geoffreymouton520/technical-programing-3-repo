/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.BodyStatGoalFactory;
import com.geoffrey.gymapp.domain.BodyStatGoal;
import com.geoffrey.gymapp.domain.StatGroup;
import com.geoffrey.gymapp.presentation.web.model.BodyStatGoalModel;
import com.geoffrey.gymapp.services.BodyStatGoalConvertModelToDomain;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("bodyStatGoalConvertModelToDomain")
public class BodyStatGoalConvertModelToDomainImpl implements BodyStatGoalConvertModelToDomain{


    @Override
    public BodyStatGoal convertToBodyStatGoal(BodyStatGoalModel bodyStatGoalModel) {
        StatGroup statGroup = StatGroup.valueOf(bodyStatGoalModel.getStatGroup());
        float stat = Float.parseFloat(bodyStatGoalModel.getStatGoal());
        
        BodyStatGoalFactory bodyStatGoalFactory = BodyStatGoalFactory.getInstance();
        BodyStatGoal bodyStatGoal = bodyStatGoalFactory.getBodyStatGoal(stat, statGroup);
        return bodyStatGoal;
    }
    
}
