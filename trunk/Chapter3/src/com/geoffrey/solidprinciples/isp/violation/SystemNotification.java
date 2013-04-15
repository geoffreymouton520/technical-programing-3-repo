/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.isp.violation;

/**
 *
 * @author geoffrey
 */
public class SystemNotification implements Notifier{

    @Override
    public String sendNotification(String type) {
        return "This is a system notification: "+type;
    }

    @Override
    public String fire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String hire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
