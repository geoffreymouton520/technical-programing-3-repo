/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part1;

/**
 *
 * @author geoffrey
 */
public abstract class Hero {
    protected String heroName;
    protected String battleCry;

    public Hero(String heroName, String battleCry) {
        this.heroName = heroName;
        this.battleCry = battleCry;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getBattleCry() {
        return battleCry;
    }

    public void setBattleCry(String battleCry) {
        this.battleCry = battleCry;
    }
    
    public String battleCry() {
        return battleCry;
    }
    public abstract String chargeIn();
}
