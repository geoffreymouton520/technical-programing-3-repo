/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.valid;

/**
 *
 * @author geoffrey
 */
public class Table extends Funiture{

    public Table(String condition, int rate, String woodtype) {
        super(condition, rate, woodtype);
    }

    @Override
    public void refurnish() {
        condition = "refurnish";
        rate += 15;
    }
    
}
