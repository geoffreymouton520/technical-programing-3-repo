/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.voilation;

/**
 *
 * @author geoffrey
 */
public class Crafter {
    public void refurnishChair(Chair chair){
        chair.setCondition("Refurnished chair");
        int rating = chair.getRate()+10;
        chair.setRate(rating);
    }
    public void refurnishTable(Table table){
        table.setCondition("Refurnished table");
        int rating = table.getRate()+10;
        table.setRate(rating);
    }
}
