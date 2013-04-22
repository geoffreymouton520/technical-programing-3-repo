/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.Statistic;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class StatisticFactory {
    private static StatisticFactory statisticFactory;

    private StatisticFactory() {
    }
    
    public static StatisticFactory getInstance(){
        if (statisticFactory == null) {
            statisticFactory = new StatisticFactory();
        }
        return statisticFactory;
    }
    
    public Statistic getStatistic(Map<String, Integer> values, Date dateLogged, float weight){
        Statistic statistic = new Statistic();
       
        statistic.setDateLogged(dateLogged);
        statistic.setRepitions(values.get("Repitions"));
        statistic.setSetNumber(values.get("SetNumber"));
        statistic.setWeight(weight);
        return statistic;
    }
}
