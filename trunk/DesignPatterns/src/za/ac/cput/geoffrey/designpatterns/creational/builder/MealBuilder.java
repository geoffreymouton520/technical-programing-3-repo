/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.builder;

/**
 *
 * @author geoffrey
 */
public interface MealBuilder {
    public void buildDrink();
    public void buildMainCourse();
    public void buildSide();
    public Meal getMeal();
    
}
