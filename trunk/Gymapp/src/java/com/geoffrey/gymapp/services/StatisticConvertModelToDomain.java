/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Statistic;
import com.geoffrey.gymapp.presentation.web.model.StatisticModel;

/**
 *
 * @author geoffrey
 */
public interface StatisticConvertModelToDomain {

    public Statistic convertToStatistic(StatisticModel statisticModel);
    
}
