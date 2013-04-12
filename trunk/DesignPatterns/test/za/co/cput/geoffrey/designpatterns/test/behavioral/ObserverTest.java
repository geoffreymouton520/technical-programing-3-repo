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
import za.ac.cput.geoffrey.designpatterns.behavioral.observer.WeatherCustomer1;
import za.ac.cput.geoffrey.designpatterns.behavioral.observer.WeatherCustomer2;
import za.ac.cput.geoffrey.designpatterns.behavioral.observer.WeatherStation;

/**
 *
 * @author geoffrey
 */
public class ObserverTest {

    public ObserverTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        WeatherStation weatherStation = new WeatherStation(33);

        WeatherCustomer1 wc1 = new WeatherCustomer1();
        WeatherCustomer2 wc2 = new WeatherCustomer2();
        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);

        Assert.assertEquals(weatherStation.setTemperature(34), "Weather station setting temperature to 34");
        
        weatherStation.removeObserver(wc1);

        Assert.assertEquals(weatherStation.setTemperature(35), "Weather station setting temperature to 35");
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
