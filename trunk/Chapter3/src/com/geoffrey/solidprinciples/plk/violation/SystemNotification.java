/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.plk.violation;

/**
 *
 * @author geoffrey
 */
public class SystemNotification implements Notifier{

    @Override
    public String sendNotification(String type) {
        return "This is a system notification: "+type;
    }

    
}
