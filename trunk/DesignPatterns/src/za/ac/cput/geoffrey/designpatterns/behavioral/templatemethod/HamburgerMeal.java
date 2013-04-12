/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod;

/**
 *
 * @author geoffrey
 */
public class HamburgerMeal extends Meal{

    @Override
    public String prepareIngredient() {
        return("Getting burgers, buns, and french fries");
    }

    @Override
    public String cook() {
        return("Cooking burgers on grill and fries in oven");
    }

    @Override
    public String cleanUp() {
        return("Throwing away paper plates");
    }
    
}
