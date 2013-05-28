/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.model;

import java.io.Serializable;

/**
 *
 * @author 211026298
 */
public class ExerciseModel implements Serializable{
    private String id;
    private String caloriesBurned;
    private String description;
    private String equipment;
    private String instructions;
    private String name;
    private String muscleGroup; 
    private String repitions;
    private String exerciseSets;
    private String weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(String caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    
}
