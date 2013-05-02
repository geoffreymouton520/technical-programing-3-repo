/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author geoffrey
 */
@Entity
public class Preferences implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int restTimeInSeconds;
    private MeasuringUnit measuringUnit;
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name="preference_id")
    private List<ExercisePreference> exercisePreferences = new ArrayList<ExercisePreference>();

    public int getRestTimeInSeconds() {
        return restTimeInSeconds;
    }

    public void setRestTimeInSeconds(int restTimeInSeconds) {
        this.restTimeInSeconds = restTimeInSeconds;
    }

    public MeasuringUnit getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(MeasuringUnit measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public List<ExercisePreference> getExercisePreferences() {
        return exercisePreferences;
    }

    public void setExercisePreferences(List<ExercisePreference> exercisePreferences) {
        this.exercisePreferences = exercisePreferences;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferences)) {
            return false;
        }
        Preferences other = (Preferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoffrey.gymapp.domain.Preferences[ id=" + id + " ]";
    }
    
}
