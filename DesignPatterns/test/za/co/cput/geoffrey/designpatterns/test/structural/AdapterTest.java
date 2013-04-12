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
import za.ac.cput.geoffrey.designpatterns.structural.adapter.TemperatureClassReporter;
import za.ac.cput.geoffrey.designpatterns.structural.adapter.TemperatureInfo;
import za.ac.cput.geoffrey.designpatterns.structural.adapter.TemperatureObjectReporter;


/**
 *
 * @author geoffrey
 */
public class AdapterTest {

    public AdapterTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
        // class adapter
        TemperatureInfo tempInfo = new TemperatureClassReporter();
        tempInfo.setTemperatureInC(0);
        Assert.assertEquals(tempInfo.getTemperatureInC(), 0.0);
        Assert.assertEquals(tempInfo.getTemperatureInF(), 32.0);
        tempInfo.setTemperatureInF(85);
        Assert.assertEquals(tempInfo.getTemperatureInC(), 29.444444444444443);
        Assert.assertEquals(tempInfo.getTemperatureInF(), 85.0);
        
        // object adapter
        tempInfo = new TemperatureObjectReporter();
        tempInfo.setTemperatureInF(85);
        tempInfo.setTemperatureInC(0);
        Assert.assertEquals(tempInfo.getTemperatureInC(), 0.0);
        Assert.assertEquals(tempInfo.getTemperatureInF(), 32.0);
        tempInfo.setTemperatureInF(85);
        Assert.assertEquals(tempInfo.getTemperatureInC(), 29.444444444444443);
        Assert.assertEquals(tempInfo.getTemperatureInF(), 85.0);
        
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
