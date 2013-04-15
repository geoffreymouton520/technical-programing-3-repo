/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.lsp.violation;

/**
 *
 * @author geoffrey
 */
public class MetaHero implements Hero{

    @Override
    public String fly() {
        return "I can fly faster than a plane.";
    }

    @Override
    public String run() {
        return "I can run faster than a bullet.";
    }
    
}
