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
public class FitnessRoutineModel implements Serializable{
    private String id;
    private String fitnessLevel;
    private String name;
    private String routineType;
    private List<String> workoutIDs = new ArrayList<String>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoutineType() {
        return routineType;
    }

    public void setRoutineType(String routineType) {
        this.routineType = routineType;
    }

    public List<String> getWorkoutIDs() {
        return workoutIDs;
    }

    public void setWorkoutIDs(List<String> workoutIDs) {
        this.workoutIDs = workoutIDs;
    }
    
    
}
