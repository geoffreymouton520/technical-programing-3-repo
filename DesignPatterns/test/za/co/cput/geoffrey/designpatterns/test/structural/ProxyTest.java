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
import za.ac.cput.geoffrey.designpatterns.structural.proxy.FastThing;
import za.ac.cput.geoffrey.designpatterns.structural.proxy.Proxy;

/**
 *
 * @author geoffrey
 */
public class ProxyTest {

    public ProxyTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Proxy proxy = new Proxy();

        FastThing fastThing = new FastThing();
        Assert.assertEquals(fastThing.sayHello(), "FastThing says howdy");
        Assert.assertEquals(proxy.sayHello(), "SlowThing says howdy");
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
