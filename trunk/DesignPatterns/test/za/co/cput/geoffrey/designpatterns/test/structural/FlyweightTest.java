/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.structural;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.structural.flyweight.Flyweight;
import za.ac.cput.geoffrey.designpatterns.structural.flyweight.FlyweightFactory;

/**
 *
 * @author geoffrey
 */
public class FlyweightTest {

    public FlyweightTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
        
        List<Integer> anwsers = new ArrayList<>();
        anwsers.add(0);
        anwsers.add(0);
        anwsers.add(2);
        anwsers.add(1);
        anwsers.add(4);
        anwsers.add(4);
        anwsers.add(6);
        anwsers.add(9);
        anwsers.add(8);
        anwsers.add(16);
        
        List<Integer> results = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Flyweight flyweightAdder = flyweightFactory.getFlyweight("add");
            results.add(flyweightAdder.doMath(i, i));

            Flyweight flyweightMultiplier = flyweightFactory.getFlyweight("multiply");
            results.add(flyweightMultiplier.doMath(i, i));
        }
        for (int i = 0; i < 10; i++) {
            int answer = anwsers.get(i);
            int result = results.get(i);
            Assert.assertEquals(result, answer, "Test " + i);
        }

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
