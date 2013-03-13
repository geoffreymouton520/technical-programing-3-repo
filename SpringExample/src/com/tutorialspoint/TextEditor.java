/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint;

/**
 *
 * @author geoffrey
 */
public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setTextEditor.");
        this.spellChecker = spellChecker;
    }
    
    
    
    public void spellCheck(){
        spellChecker.checkSpelling();
    }
    
    
}
