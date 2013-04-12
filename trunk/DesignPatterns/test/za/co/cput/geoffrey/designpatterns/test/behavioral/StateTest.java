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
import za.ac.cput.geoffrey.designpatterns.behavioral.state.HappyState;
import za.ac.cput.geoffrey.designpatterns.behavioral.state.Person;
import za.ac.cput.geoffrey.designpatterns.behavioral.state.SadState;

/**
 *
 * @author geoffrey
 */
public class StateTest {

    public StateTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Person person = new Person(new HappyState());
        Assert.assertEquals(person.sayHello(), "Hello, friend!");
        Assert.assertEquals(person.sayGoodbye(), "Bye, friend!");

        person.setEmotionalState(new SadState());
        Assert.assertEquals(person.sayHello(), "Hello. Sniff, sniff.");
        Assert.assertEquals(person.sayGoodbye(), "Bye. Sniff, sniff.");
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
