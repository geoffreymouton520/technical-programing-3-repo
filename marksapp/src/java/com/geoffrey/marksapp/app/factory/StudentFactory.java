/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.app.factory;

import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Student;

import java.util.Map;

/**
 *
 * @author boniface
 */
public class StudentFactory {

    public static Student getStudent(Demographic demographic,
            Map<String, String> values) {
        Student student = new Student();
        student.setDemographic(demographic);
        student.setFirstName(values.get("firstName"));
        student.setStudentNumber(values.get("studentNumber"));
        student.setLastName(values.get("lastName"));
        return student;
    }
}
