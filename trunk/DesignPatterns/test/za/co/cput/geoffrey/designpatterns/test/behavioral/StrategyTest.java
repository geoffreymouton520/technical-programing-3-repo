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
import za.ac.cput.geoffrey.designpatterns.behavioral.strategy.Context;
import za.ac.cput.geoffrey.designpatterns.behavioral.strategy.HikeStrategy;
import za.ac.cput.geoffrey.designpatterns.behavioral.strategy.SkiStrategy;
import za.ac.cput.geoffrey.designpatterns.behavioral.strategy.Strategy;

/**
 *
 * @author geoffrey
 */
public class StrategyTest {

    public StrategyTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        int temperatureInF = 60;

        Strategy skiStrategy = new SkiStrategy();
        Context context = new Context(temperatureInF, skiStrategy);

        Assert.assertFalse(context.getResult());

        Strategy hikeStrategy = new HikeStrategy();
        context.setStrategy(hikeStrategy);
        
        Assert.assertTrue(context.getResult());
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
