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
import za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility.EarthHandler;
import za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility.MercuryHandler;
import za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility.PlanetEnum;
import za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility.PlanetHandler;
import za.ac.cput.geoffrey.designpatterns.behavioral.chainofresponsibility.VenusHandler;

/**
 *
 * @author geoffrey
 */
public class ChainOfResponsibilityTest {
    
    public ChainOfResponsibilityTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        PlanetHandler mercuryHandler = new MercuryHandler();
        PlanetHandler venusHandler = new VenusHandler();
        PlanetHandler earthHandler = new EarthHandler();

        mercuryHandler.setSuccessor(venusHandler);
        venusHandler.setSuccessor(earthHandler);
        
        Assert.assertEquals(mercuryHandler.handleRequest(PlanetEnum.VENUS), "venus");
        Assert.assertEquals(mercuryHandler.handleRequest(PlanetEnum.MERCURY), "mercury");
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
