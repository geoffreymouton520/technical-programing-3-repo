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

public class StatisticModel implements Serializable {
    private String repitions;
    private String setNumber;
    private String weight;
    private String exerciseID;

    public String getRepitions() {
        return repitions;
    }

    public void setRepitions(String repitions) {
        this.repitions = repitions;
    }

    public String getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(String setNumber) {
        this.setNumber = setNumber;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

}
