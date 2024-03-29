/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.mediator;

/**
 *
 * @author geoffrey
 */
public class AmericanSeller {
    Mediator mediator;
    float priceInDollars;

    public AmericanSeller(Mediator mediator, float priceInDollars) {
        this.mediator = mediator;
        this.priceInDollars = priceInDollars;
        this.mediator.registerAmericanSeller(this);
    }
    
    public boolean isBidAccepted(float bidInDollars) {
        if (bidInDollars >= priceInDollars) {
            return true;
        } else {
            return false;
        }
    }
}
