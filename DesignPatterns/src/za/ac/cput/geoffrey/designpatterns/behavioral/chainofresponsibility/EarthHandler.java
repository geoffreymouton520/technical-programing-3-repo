/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility;

/**
 *
 * @author geoffrey
 */
public class EarthHandler extends PlanetHandler{
    @Override
    public void handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.EARTH) {
            System.out.println("EarthHandler handles " + request);
            System.out.println("Earth is comfortable.\n");
        } else {
            System.out.println("EarthHandler doesn't handles " + request);
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
}
