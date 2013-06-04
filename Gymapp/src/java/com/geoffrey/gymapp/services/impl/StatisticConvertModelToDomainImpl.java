/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.StatisticFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.Statistic;
import com.geoffrey.gymapp.presentation.web.model.StatisticModel;
import com.geoffrey.gymapp.services.StatisticConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("statisticConvertModelToDomain")
public class StatisticConvertModelToDomainImpl implements StatisticConvertModelToDomain{

    @Autowired
    private ExerciseCrudService exerciseCrudService;

    @Override
    public Statistic convertToStatistic(StatisticModel statisticModel) {
        long statisticID = Long.parseLong(statisticModel.getExerciseID());
        Exercise exercise = exerciseCrudService.findById(statisticID);
        float weight = Float.parseFloat(statisticModel.getWeight());
        int set = Integer.parseInt(statisticModel.getSetNumber());
        int rep = Integer.parseInt(statisticModel.getRepitions());
        
        Map<String, Integer> values = new HashMap<String, Integer>();
        values.put("Repitions", rep);
        values.put("SetNumber", set);
        
        Date date = new Date();
        StatisticFactory statisticFactory = StatisticFactory.getInstance();
        Statistic statistic = statisticFactory.getStatistic(values, date, weight);
        statistic.setExercise(exercise);
        return statistic;
    }
    
}
