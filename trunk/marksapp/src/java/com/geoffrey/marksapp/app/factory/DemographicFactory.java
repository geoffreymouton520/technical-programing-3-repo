/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.app.factory;

import com.geoffrey.marksapp.domain.Demographic;

/**
 *
 * @author 211026298
 */
public class DemographicFactory {
    public static Demographic getDemographic(String gender,String race){
        Demographic demographic = new Demographic();
        demographic.setGender(gender);
        demographic.setRace(race);
        return demographic;
    }
}
