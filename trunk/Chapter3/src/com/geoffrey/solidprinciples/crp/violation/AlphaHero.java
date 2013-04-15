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
public class AlphaHero extends Hero implements Flyer{

    public AlphaHero(String heroName, String battleCry) {
        super(heroName, battleCry);
    }

    @Override
    public String chargeIn() {
        return "I can " + fly();
    }

    @Override
    public String fly() {
        return "fly faster than a locamotive";
    }
    
}
