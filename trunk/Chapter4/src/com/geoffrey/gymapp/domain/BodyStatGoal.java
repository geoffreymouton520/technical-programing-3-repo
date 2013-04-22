/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author geoffrey
 */
@Entity
public class BodyStatGoal extends Goal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float statGoal;
    private StatGroup statGroup;

    public StatGroup getStatGroup() {
        return statGroup;
    }

    public void setStatGroup(StatGroup statGroup) {
        this.statGroup = statGroup;
    }

    public float getStatGoal() {
        return statGoal;
    }

    public void setStatGoal(float statGoal) {
        this.statGoal = statGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        if (!(object instanceof BodyStatGoal)) {
            return false;
        }
        BodyStatGoal other = (BodyStatGoal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoffrey.gymapp.domain.BodyStatGoal[ id=" + id + " ]";
    }
    
}
