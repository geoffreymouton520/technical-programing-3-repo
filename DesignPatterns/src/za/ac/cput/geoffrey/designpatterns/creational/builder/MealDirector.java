/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.builder;

/**
 *
 * @author geoffrey
 */
public class MealDirector {
    private MealBuilder mealBuilder = null;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
    
    public void constructMeal(){
        mealBuilder.buildDrink();
        mealBuilder.buildMainCourse();
        mealBuilder.buildSide();
    }
    
    public Meal getMeal(){
        return mealBuilder.getMeal();
    }
}
