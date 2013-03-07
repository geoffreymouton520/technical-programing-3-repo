/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.app.factory;

import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Lecturer;
import java.util.Map;

/**
 *
 * @author 211026298
 */
public class LecturerFactory {
    public static Lecturer getLecturer(Demographic demographic,Map<String, String> values){
        Lecturer lecturer = new Lecturer();
        lecturer.setDemographic(demographic);
        lecturer.setFirstName(values.get("firstName"));
        lecturer.setLastName(values.get("lastName"));
        lecturer.setStaffNumber(values.get("staffNumber"));
        return lecturer;
    }
}
