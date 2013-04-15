/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part1;

/**
 *
 * @author geoffrey
 */
public class AlphaHeroHandler implements HeroHandler {

    private HeroHandler nextHeroHandler;

    @Override
    public void setNext(HeroHandler heroHandler) {
        nextHeroHandler = heroHandler;
    }

    @Override
    public Hero handleRequest(String type, String heroName, String battleCry) {
        if ("alpha".equals(type) || nextHeroHandler == null) {
            return new AlphaHero(heroName, battleCry);
        } else {
            return nextHeroHandler.handleRequest(type, heroName, battleCry);
        }
    }
}
