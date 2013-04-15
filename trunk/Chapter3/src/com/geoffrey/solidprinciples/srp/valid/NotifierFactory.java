/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.srp.valid;

/**
 *
 * @author geoffrey
 */
public class NotifierFactory {
    private static NotifierFactory notifierFactory = null;

    private NotifierFactory() {
        
    }
    
    public static NotifierFactory getInstance(){
        if (notifierFactory == null) {
            notifierFactory = new NotifierFactory();
        }
        return notifierFactory;
    }
    
    public Notifier getNotifier(Employee employee){
        return new HRNotifier(employee);
    }
}
