/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility;

/**
 *
 * @author geoffrey
 */
public abstract class PlanetHandler {

    PlanetHandler successor;

    public void setSuccessor(PlanetHandler successor) {
        this.successor = successor;
    }
    
    public abstract String handleRequest(PlanetEnum request);
}
