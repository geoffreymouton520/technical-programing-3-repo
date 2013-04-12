/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod;

/**
 *
 * @author geoffrey
 */
public class CheeseBurgerMeal extends Meal{

    @Override
    public String prepareIngredient() {
        return("Getting ground beef and Cheese");
    }

    @Override
    public String cook() {
        return("Cooking ground beef in pan");
    }

    @Override
    public String eat(){
        return("The Cheese Burgers are tasty");
    }
    
    @Override
    public String cleanUp() {
        return("Doing the dishes");
    }
    
}
