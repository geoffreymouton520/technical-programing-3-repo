/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.srp.violation;

/**
 *
 * @author geoffrey
 */
public class HRNotifierFactory {
    private static HRNotifierFactory hRNotifierFactory = null;

    private HRNotifierFactory() {
    }
    public static HRNotifierFactory getInstance(){
        if (hRNotifierFactory == null) {
            hRNotifierFactory = new HRNotifierFactory();
        }
        return hRNotifierFactory;
    }
    public HRNotifier getHRNotifier(String name,String title){
        return new ITEmployeeNotifier(name,title);
    }
    
}
