/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.plk.valid;

/**
 *
 * @author geoffrey
 */
public class HRNotifier implements Notifier, HRServices{
    
    private Employee employee;

    public HRNotifier(Employee employee) {
        this.employee = employee;
    }
    
    
    @Override
    public String fire(){
        return ", you are fired from the it department.";
    }
    
    @Override
    public String hire(){
        return ", you are hired as a " + employee.jobTitleToUpper() + " by the IT department.";
    }
    
    @Override
    public String sendNotification(String type) {
        String message = employee.getFirstName() + " " + employee.getLastName();
        if ("fire".equals(type)) {
            message += fire();
        } else {
            message += hire();
        }
        return message;
    }
    
}
