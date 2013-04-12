/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.structural;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.structural.composite.Composite;
import za.ac.cput.geoffrey.designpatterns.structural.composite.Leaf;

/**
 *
 * @author geoffrey
 */
public class CompositeTest {

    public CompositeTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Leaf leaf1 = new Leaf("Bob");
        Leaf leaf2 = new Leaf("Fred");
        Leaf leaf3 = new Leaf("Sue");
        Leaf leaf4 = new Leaf("Ellen");
        Leaf leaf5 = new Leaf("Joe");

        Composite composite1 = new Composite();
        composite1.add(leaf1);
        composite1.add(leaf2);

        Composite composite2 = new Composite();
        composite2.add(leaf3);
        composite2.add(leaf4);

        Composite composite3 = new Composite();
        composite3.add(composite1);
        composite3.add(composite2);
        composite3.add(leaf5);

        Assert.assertEquals( leaf1.sayHello(), "Bob leaf says hello ");

        Assert.assertEquals( composite1.sayHello(), "Bob leaf says hello "
                + "Fred leaf says hello ");

        Assert.assertEquals( composite2.sayHello(), "Sue leaf says hello "
                + "Ellen leaf says hello ");
        
        Assert.assertEquals( composite3.sayGoodbye(), "Bob leaf says goodbye "
                + "Fred leaf says goodbye "
                + "Sue leaf says goodbye "
                + "Ellen leaf says goodbye "
                + "Joe leaf says goodbye ");
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
