/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part2;

import com.geoffrey.tdd.part1.*;

/**
 *
 * @author geoffrey
 */
public class MajesticHeroHander implements HeroHandler{
    private HeroHandler nextHeroHandler;

    @Override
    public void setNext(HeroHandler heroHandler) {
        nextHeroHandler = heroHandler;
    }

    @Override
    public Hero handleRequest(String type,String heroName, String battleCry) {
        if ("majestic".equals(type)|| nextHeroHandler==null) {
            MajesticHero majesticHero = new MajesticHero(heroName, battleCry);
            
            FlyerFactory flyerFactory = FlyerFactory.getInstance();
            Flyer superFlyer = flyerFactory.getFlyer("super");

            SpeedsterFactory speedsterFactory = SpeedsterFactory.getInstance();
            Speedster superSpeedster = speedsterFactory.getSpeedster("super");
            
            majesticHero.setFlyer(superFlyer);
            majesticHero.setSpeedster(superSpeedster);
            return majesticHero;
        }else {
            return nextHeroHandler.handleRequest(type,heroName,battleCry);
        }
    }
    
}
