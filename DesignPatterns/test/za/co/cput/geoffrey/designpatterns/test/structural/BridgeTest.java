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
import za.ac.cput.geoffrey.designpatterns.structural.bridge.BigBus;
import za.ac.cput.geoffrey.designpatterns.structural.bridge.BigEngine;
import za.ac.cput.geoffrey.designpatterns.structural.bridge.SmallCar;
import za.ac.cput.geoffrey.designpatterns.structural.bridge.SmallEngine;
import za.ac.cput.geoffrey.designpatterns.structural.bridge.Vehicle;

/**
 *
 * @author geoffrey
 */
public class BridgeTest {

    public BridgeTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Vehicle vehicle = new BigBus(new SmallEngine());
        Assert.assertEquals(vehicle.drive(),"The big bus is driving "
                + "The small engine is running "
                + "The vehicle is going at a slow speed.");
        vehicle.setEngine(new BigEngine());
        Assert.assertEquals(vehicle.drive(), "The big bus is driving "
                + "The big engine is running "
                + "The vehicle is going at a slow speed.");
        vehicle.drive();

        vehicle = new SmallCar(new SmallEngine());
        Assert.assertEquals(vehicle.drive(), "The small car is driving "
                + "The small engine is running "
                + "The vehicle is going at a average speed.");
        vehicle.drive();
        vehicle.setEngine(new BigEngine());
        Assert.assertEquals(vehicle.drive(), "The small car is driving "
                + "The big engine is running "
                + "The vehicle is going at a fast speed.");
        vehicle.drive();
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
