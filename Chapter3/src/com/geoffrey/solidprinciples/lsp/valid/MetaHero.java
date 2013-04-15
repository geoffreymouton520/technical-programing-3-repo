/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.lsp.valid;

/**
 *
 * @author geoffrey
 */
public class MetaHero implements Hero{

    public String fly() {
        return "I can fly faster than a plane.";
    }

    @Override
    public String run() {
        return "I can run faster than a bullet.";
    }
    
}
