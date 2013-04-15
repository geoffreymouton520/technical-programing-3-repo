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
public class BetaHero extends Hero implements Speedster{
    private Speedster speedster;
    public BetaHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }
    @Override
    public String chargeIn() {
        return "I can " + run();
    }

    @Override
    public String run() {
        return speedster.run();
    }

    public void setSpeedster(Speedster speedster) {
        this.speedster = speedster;
    }
    
}
