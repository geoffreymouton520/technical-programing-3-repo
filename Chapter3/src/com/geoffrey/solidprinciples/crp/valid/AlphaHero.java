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
public class AlphaHero extends Hero {

    private Flyer flyer;
    public AlphaHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }

    @Override
    public String chargeIn() {
        return "I can " + fly();
    }
    
    public String fly() {
        return flyer.fly();
    }

    public void setFlyer(Flyer flyer) {
        this.flyer = flyer;
    }
    
}
