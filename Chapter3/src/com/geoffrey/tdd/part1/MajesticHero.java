/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part1;

/**
 *
 * @author geoffrey
 */
public class MajesticHero extends Hero implements Flyer,Speedster{

    public MajesticHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }
    
    @Override
    public String chargeIn() {
        return "I either " + fly() + " or " + run();
    }

    @Override
    public String fly() {
        return "fly supersonic";
    }

    @Override
    public String run() {
        return "run faster than light";
    }
    
}
