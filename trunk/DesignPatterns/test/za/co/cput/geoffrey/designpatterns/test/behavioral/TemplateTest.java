/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.behavioral;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod.CheeseBurgerMeal;
import za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod.HamburgerMeal;
import za.ac.cput.geoffrey.designpatterns.behavioral.templatemethod.Meal;

/**
 *
 * @author geoffrey
 */
public class TemplateTest {

    public TemplateTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Meal meal1 = new HamburgerMeal();
        meal1.doMeal();

        Assert.assertEquals(meal1.doMeal(), "Getting burgers, buns, and french fries "
                + "Cooking burgers on grill and fries in oven "
                + "Mmm, that's good Throwing away paper plates");

        Meal meal2 = new CheeseBurgerMeal();
        meal2.doMeal();
        Assert.assertEquals(meal2.doMeal(), "Getting ground beef and Cheese "
                + "Cooking ground beef in pan "
                + "The Cheese Burgers are tasty "
                + "Doing the dishes");
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
