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

public class BodyStatGoalModel implements Serializable {
    private String id;
    private String statGoal;
    private String statGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getStatGoal() {
        return statGoal;
    }

    public void setStatGoal(String statGoal) {
        this.statGoal = statGoal;
    }

    public String getStatGroup() {
        return statGroup;
    }

    public void setStatGroup(String statGroup) {
        this.statGroup = statGroup;
    }

}
