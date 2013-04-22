/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.MeasuringUnit;
import com.geoffrey.gymapp.domain.Preferences;

/**
 *
 * @author geoffrey
 */
public class PreferencesFactory {
    private static PreferencesFactory preferencesFactory;

    private PreferencesFactory() {
    }
    
    public static PreferencesFactory getInstance(){
        if (preferencesFactory == null) {
            preferencesFactory = new PreferencesFactory();
        }
        return preferencesFactory;
    }
    
    public Preferences getPreferences(MeasuringUnit measuringUnit, int restTimeInSeconds){
        Preferences preferences = new Preferences();
       
        preferences.setMeasuringUnit(measuringUnit);
        preferences.setRestTimeInSeconds(restTimeInSeconds);
        return preferences;
    }
}
