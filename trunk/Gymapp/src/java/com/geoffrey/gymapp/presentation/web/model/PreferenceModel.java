/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.model;

import java.io.Serializable;

/**
 *
 * @author geoffrey
 */
public class PreferenceModel implements Serializable{
    private String restTimeInSeconds;
    private String measuringUnit;

    public String getRestTimeInSeconds() {
        return restTimeInSeconds;
    }

    public void setRestTimeInSeconds(String restTimeInSeconds) {
        this.restTimeInSeconds = restTimeInSeconds;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }
    
    
}
