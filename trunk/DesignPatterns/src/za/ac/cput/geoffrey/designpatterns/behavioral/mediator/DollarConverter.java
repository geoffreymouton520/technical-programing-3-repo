/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.mediator;

/**
 *
 * @author geoffrey
 */
public class DollarConverter {

    Mediator mediator;
    public static final float DOLLAR_UNIT = 1.0f;
    public static final float EURO_UNIT = 0.7f;
    public static final float KRONA_UNIT = 8.0f;

    public DollarConverter(Mediator mediator) {
        this.mediator = mediator;
        mediator.registerDollarConvert(this);
    }
    
    private float convertEurosToDollars(float euros) {
        float dollars = euros * (DOLLAR_UNIT / EURO_UNIT);
        return dollars;
    }
    
    private float convertKronorToDollars(float kronor) {
        float dollars = kronor * (DOLLAR_UNIT / KRONA_UNIT);
        return dollars;
    }
    public float convertCurrencyToDollars(float bid, String unitOfCurrency) {
        if ("krona".equals(unitOfCurrency)) {
            return convertKronorToDollars(bid);
        } else {
            return convertEurosToDollars(bid);
        }
    }
    
}
