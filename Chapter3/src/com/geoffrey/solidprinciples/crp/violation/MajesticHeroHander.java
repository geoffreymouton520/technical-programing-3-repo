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
public class MajesticHeroHander implements HeroHandler {

    private HeroHandler nextHeroHandler;

    @Override
    public void setNext(HeroHandler heroHandler) {
        nextHeroHandler = heroHandler;
    }

    @Override
    public Hero handleRequest(String type, String heroName, String battleCry) {
        if ("majestic".equals(type) || nextHeroHandler == null) {
            return new MajesticHero(heroName, battleCry);
        } else {
            return nextHeroHandler.handleRequest(type, heroName, battleCry);
        }
    }
}
