/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.voilation;

/**
 *
 * @author geoffrey
 */
public class Chair {
    private String condition;
    private int rate;
    private String woodtype;
    public Chair(String condition, int rate, String woodtype) {
        this.condition = condition;
        this.rate = rate;
        this.woodtype = woodtype;
    }

    public String getWoodtype() {
        return woodtype;
    }

    public void setWoodtype(String woodtype) {
        this.woodtype = woodtype;
    }
    
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
}
