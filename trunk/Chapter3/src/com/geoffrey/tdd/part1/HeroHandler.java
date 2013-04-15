/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.tdd.part1;

/**
 *
 * @author geoffrey
 */
public interface HeroHandler{
    public void setNext(HeroHandler heroHandler);
    public Hero handleRequest(String type,String heroName, String battleCry);
}
