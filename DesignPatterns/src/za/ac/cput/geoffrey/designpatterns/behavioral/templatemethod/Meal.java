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
    public final void doMeal(){
        prepareIngredient();
        cook();
        eat();
        cleanUp();
    }

    public abstract void prepareIngredient();

    public abstract void cook();

    public void eat() {
        System.out.println("Mmm, that's good");
    }

    public abstract void cleanUp();
}
