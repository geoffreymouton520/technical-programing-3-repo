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
public class ExercisePreferenceModel implements Serializable{
    private String id;
    private String exerciseID;
    private String repitions;
    private String exerciseSets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getRepitions() {
        return repitions;
    }

    public void setRepitions(String repitions) {
        this.repitions = repitions;
    }

    public String getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(String exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
    
}
