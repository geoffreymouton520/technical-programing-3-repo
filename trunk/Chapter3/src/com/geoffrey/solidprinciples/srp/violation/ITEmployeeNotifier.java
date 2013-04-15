/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.srp.violation;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author geoffrey
 */
public class ITEmployeeNotifier implements HRNotifier{
    private String empName;
    private String jobTitle;

    public ITEmployeeNotifier(String empName, String jobTitle) {
        this.empName = empName;
        this.jobTitle = jobTitle;
    }
    
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String fire() {
        return empName + ", you are fired from the it department.";
    }

    @Override
    public String hire() {
        return empName + ", you are hired as a " + jobTitle + " by the IT department.";
    }
}
