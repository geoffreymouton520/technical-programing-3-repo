/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoffrey
 */

public class WorkoutModel implements Serializable {
    private String id;
    private String fitnessLevel;
    private String totalCaloriesBurned;
    private String workoutDurationInMins;
    private List<String> workoutItemsId = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(String totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public String getWorkoutDurationInMins() {
        return workoutDurationInMins;
    }

    public void setWorkoutDurationInMins(String workoutDurationInMins) {
        this.workoutDurationInMins = workoutDurationInMins;
    }

    public List<String> getWorkoutItemsId() {
        return workoutItemsId;
    }

    public void setWorkoutItemsId(List<String> workoutItemsId) {
        this.workoutItemsId = workoutItemsId;
    }
    
}
