/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.dip.violation;

import com.geoffrey.solidprinciples.ocp.valid.*;

/**
 *
 * @author geoffrey
 */
public class Crafter {
    public void refurnishFuniture(Funiture funiture){
        funiture.refurnish();
    }
}
