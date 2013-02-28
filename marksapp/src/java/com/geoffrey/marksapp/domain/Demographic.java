/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 211026298
 */
@Embeddable
public class Demographic implements Serializable {
    private String gender;
    private String race;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
}
