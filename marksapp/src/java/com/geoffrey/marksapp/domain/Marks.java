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
public class Marks implements Serializable {
    private double mark;
    private String grade;

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
}
