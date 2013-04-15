/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.lsp.violation;



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
    
    public Hero getHero(String type){
        if ("meta".equals(type)) {
            return new MetaHero();
        } else {
            return new RichHero();
        }
    }
}
