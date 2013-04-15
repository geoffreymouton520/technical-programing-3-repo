/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part2;

/**
 *
 * @author geoffrey
 */
public class SpeedsterFactory {
    private static SpeedsterFactory speedsterFactory = null;

    private SpeedsterFactory() {
    }
    
    public static SpeedsterFactory getInstance(){
        if (speedsterFactory == null) {
            speedsterFactory = new SpeedsterFactory();
        }
        return speedsterFactory;
    }
    
    public Speedster getSpeedster(String type){
        if ("super".equals(type)) {
            return new SuperSpeedster();
        } else {
            return new StandardSpeedster();
        }
    }
}
