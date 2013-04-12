/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.creational;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.creational.builder.ItalianMealBuilder;
import za.ac.cput.geoffrey.designpatterns.creational.builder.JapaneseMealBuilder;
import za.ac.cput.geoffrey.designpatterns.creational.builder.Meal;
import za.ac.cput.geoffrey.designpatterns.creational.builder.MealBuilder;
import za.ac.cput.geoffrey.designpatterns.creational.builder.MealDirector;

/**
 *
 * @author geoffrey
 */
public class BuilderTest {

    public BuilderTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        MealBuilder mealBuilder = new ItalianMealBuilder();
        MealDirector mealDirector = new MealDirector(mealBuilder);
        mealDirector.constructMeal();
        Meal meal = mealDirector.getMeal();
        Assert.assertEquals(meal.toString(), "drink:red wine, main course:pizza, side:bread");

        mealBuilder = new JapaneseMealBuilder();
        mealDirector = new MealDirector(mealBuilder);
        mealDirector.constructMeal();
        meal = mealDirector.getMeal();
        Assert.assertEquals(meal.toString(), "drink:sake, main course:chicken teriyaki, side:miso soup");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
