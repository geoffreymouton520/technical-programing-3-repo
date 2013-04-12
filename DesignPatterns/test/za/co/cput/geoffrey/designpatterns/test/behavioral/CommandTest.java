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
import za.ac.cput.geoffrey.designpatterns.behavioral.command.Command;
import za.ac.cput.geoffrey.designpatterns.behavioral.command.Dinner;
import za.ac.cput.geoffrey.designpatterns.behavioral.command.DinnerCommand;
import za.ac.cput.geoffrey.designpatterns.behavioral.command.Lunch;
import za.ac.cput.geoffrey.designpatterns.behavioral.command.LunchCommand;
import za.ac.cput.geoffrey.designpatterns.behavioral.command.MealInvoker;

/**
 *
 * @author geoffrey
 */
public class CommandTest {
    
    public CommandTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        Lunch lunch = new Lunch(); // receiver
        Command lunchCommand = new LunchCommand(lunch); // concrete command

        Dinner dinner = new Dinner(); // receiver
        Command dinnerCommand = new DinnerCommand(dinner); // concrete command

        MealInvoker mealInvoker = new MealInvoker(lunchCommand); // invoker
        Assert.assertEquals(mealInvoker.invoke(), "Lunch is being made");

        mealInvoker.setCommand(dinnerCommand);
        Assert.assertEquals(mealInvoker.invoke(), "Dinner is being made");
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
