/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.crp.valid;

import com.geoffrey.tdd.part2.*;

/**
 *
 * @author geoffrey
 */
public class FlyerFactory {
    private static FlyerFactory flyerFactory = null;

    private FlyerFactory() {
    }
    
    public static FlyerFactory getInstance(){
        if (flyerFactory == null) {
            flyerFactory = new FlyerFactory();
        }
        return flyerFactory;
    }
    
    public Flyer getFlyer(String type){
        if ("super".equals(type)) {
            return new SuperFlyer();
        } else {
            return new StandardFlyer();
        }
    }
}
