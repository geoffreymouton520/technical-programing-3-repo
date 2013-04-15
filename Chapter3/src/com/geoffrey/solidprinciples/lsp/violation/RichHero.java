/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.lsp.violation;

/**
 *
 * @author geoffrey
 */
public class RichHero implements Hero{

    @Override
    public String fly() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String run() {
        return "I can faster than normal.";
    }
    
}
