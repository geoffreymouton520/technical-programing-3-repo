/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility;

/**
 *
 * @author geoffrey
 */
public class VenusHandler extends PlanetHandler{
    @Override
    public String handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.VENUS) {
            return "venus";
        } else {
            return successor.handleRequest(request);
        }
    }
}
