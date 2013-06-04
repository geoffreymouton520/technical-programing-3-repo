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

public class ExerciseGoalModel implements Serializable {
    private String id;
    private String weight;
    private String exerciseSets;
    private String exerciseID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(String exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

    
}
