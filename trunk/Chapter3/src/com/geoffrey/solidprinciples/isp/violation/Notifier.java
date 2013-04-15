/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.isp.violation;

/**
 *
 * @author geoffrey
 */
public interface Notifier {
    public String sendNotification(String type);
    public String fire();
    public String hire();
}
