/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part2;

/**
 *
 * @author geoffrey
 */
public class MajesticHero extends Hero implements Speedster{

    private Flyer flyer;
    private Speedster speedster;
    
    public MajesticHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }
    
    @Override
    public String chargeIn() {
        return "I either " + fly() + " or " + run();
    }

    public String fly() {
        return flyer.fly(); 
    }

    @Override
    public String run() {
        return speedster.run();
    }

    public void setFlyer(Flyer flyer) {
        this.flyer = flyer;
    }

    public void setSpeedster(Speedster speedster) {
        this.speedster = speedster;
    }
    
}
