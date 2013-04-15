/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part1;

/**
 *
 * @author geoffrey
 */
public class HeroFactory {
    private static HeroFactory heroFactory = null;

    private HeroFactory() {
    }
    
    public static HeroFactory getInstance(){
        if (heroFactory == null) {
            heroFactory = new HeroFactory();
        }
        return heroFactory;
    }
    
    public Hero getHero(String type,String heroName, String battleCry){
        HeroHandler majesticHeroHandler = new MajesticHeroHander();
        HeroHandler alphaHeroHandler = new AlphaHeroHandler();
        HeroHandler betaHeroHandler = new BetaHeroHandler();
        
        majesticHeroHandler.setNext(alphaHeroHandler);
        alphaHeroHandler.setNext(betaHeroHandler);
        
        return majesticHeroHandler.handleRequest(type, heroName, battleCry);
    }
}
