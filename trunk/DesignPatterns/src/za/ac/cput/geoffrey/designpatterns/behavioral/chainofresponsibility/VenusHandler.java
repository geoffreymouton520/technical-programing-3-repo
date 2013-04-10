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
    public void handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.VENUS) {
            System.out.println("VenusHandler handles " + request);
            System.out.println("Venus is poisonous.\n");
        } else {
            System.out.println("VenusHandler doesn't handles " + request);
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
}
