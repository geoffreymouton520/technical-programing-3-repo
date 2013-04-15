/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.lsp.valid;

/**
 *
 * @author geoffrey
 */
public class RichHero implements Hero{

    @Override
    public String run() {
        return "I can faster than normal.";
    }
    
}
