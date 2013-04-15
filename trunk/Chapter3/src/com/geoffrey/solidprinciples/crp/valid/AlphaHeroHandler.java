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
public class AlphaHeroHandler implements HeroHandler {

    private HeroHandler nextHeroHandler;

    @Override
    public void setNext(HeroHandler heroHandler) {
        nextHeroHandler = heroHandler;
    }

    @Override
    public Hero handleRequest(String type, String heroName, String battleCry) {
        if ("alpha".equals(type) || nextHeroHandler == null) {
            AlphaHero alphaHero = new AlphaHero(heroName, battleCry);

            FlyerFactory flyerFactory = FlyerFactory.getInstance();
            Flyer standardFlyer = flyerFactory.getFlyer("standard");

            alphaHero.setFlyer(standardFlyer);
            return alphaHero;
        } else {
            return nextHeroHandler.handleRequest(type, heroName, battleCry);
        }
    }
}
