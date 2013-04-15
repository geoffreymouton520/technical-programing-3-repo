/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.crp.violation;

import com.geoffrey.tdd.part1.*;

/**
 *
 * @author geoffrey
 */
public class BetaHero extends Hero implements Speedster{

    public BetaHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }
    @Override
    public String chargeIn() {
        return "I can " + run();
    }

    @Override
    public String run() {
        return "run faster than speeding bullet";
    }
    
}
