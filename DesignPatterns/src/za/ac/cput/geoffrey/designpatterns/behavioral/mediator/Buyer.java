/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.mediator;

/**
 *
 * @author geoffrey
 */
public class Buyer {
    Mediator mediator;
    String unitOfCurrency;

    public Buyer(Mediator mediator, String unitOfCurrency) {
        this.mediator = mediator;
        this.unitOfCurrency = unitOfCurrency;
    }
    
    public boolean attemptToPurchase(float bid){
        return mediator.placeBid(bid, unitOfCurrency);
    }
}
