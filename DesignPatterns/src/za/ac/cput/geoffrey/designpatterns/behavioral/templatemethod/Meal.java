/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod;

/**
 *
 * @author geoffrey
 */
public abstract class Meal {
    public final String doMeal(){
        return prepareIngredient()+" "+
                cook()+" "+
                eat()+" "+
                cleanUp();
    }

    public abstract String prepareIngredient();

    public abstract String cook();

    public String eat() {
        return "Mmm, that's good";
    }

    public abstract String cleanUp();
}
