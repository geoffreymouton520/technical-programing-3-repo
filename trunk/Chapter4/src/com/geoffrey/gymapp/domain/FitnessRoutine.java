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
public class FitnessRoutine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private FitnessLevel fitnessLevel;
    private String name;
    private RoutineType routineType;
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name="fitnessroutine_id")
    private List<RoutineItem> routineItems = new ArrayList<RoutineItem>();

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(FitnessLevel fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoutineType getRoutineType() {
        return routineType;
    }

    public void setRoutineType(RoutineType routineType) {
        this.routineType = routineType;
    }

    public List<RoutineItem> getRoutineItems() {
        return routineItems;
    }

    public void setRoutineItems(List<RoutineItem> routineItems) {
        this.routineItems = routineItems;
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
        if (!(object instanceof FitnessRoutine)) {
            return false;
        }
        FitnessRoutine other = (FitnessRoutine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoffrey.gymapp.domain.Routine[ id=" + id + " ]";
    }
    
}
