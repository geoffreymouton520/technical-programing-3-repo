/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.dip.violation;

/**
 *
 * @author geoffrey
 */
public class Chair extends Funiture{

    public Chair(String condition, int rate, String woodtype) {
        super(condition, rate, woodtype);
    }

    @Override
    public void refurnish() {
        condition = "refurnish";
        rate += 5;
    }
    
    
}
