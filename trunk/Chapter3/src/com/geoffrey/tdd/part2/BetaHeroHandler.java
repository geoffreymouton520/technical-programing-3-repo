/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part2;

/**
 *
 * @author geoffrey
 */
public class BetaHeroHandler implements HeroHandler {

    private HeroHandler nextHeroHandler;

    @Override
    public void setNext(HeroHandler heroHandler) {
        nextHeroHandler = heroHandler;
    }

    @Override
    public Hero handleRequest(String type, String heroName, String battleCry) {
        if ("beta".equals(type) || nextHeroHandler == null) {
            BetaHero betaHero = new BetaHero(heroName, battleCry);

            SpeedsterFactory speedsterFactory = SpeedsterFactory.getInstance();
            Speedster standardSpeedster = speedsterFactory.getSpeedster("standard");

            betaHero.setSpeedster(standardSpeedster);
            return betaHero;
        } else {
            return nextHeroHandler.handleRequest(type, heroName, battleCry);
        }
    }
}
