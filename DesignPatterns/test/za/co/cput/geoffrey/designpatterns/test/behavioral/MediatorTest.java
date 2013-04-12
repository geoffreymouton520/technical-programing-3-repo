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
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.AmericanSeller;
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.Buyer;
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.DollarConverter;
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.FrenchBuyer;
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.Mediator;
import za.ac.cput.geoffrey.designpatterns.behavioral.mediator.SwedishBuyer;

/**
 *
 * @author geoffrey
 */
public class MediatorTest {

    public MediatorTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Mediator mediator = new Mediator();

        Buyer swedishBuyer = new SwedishBuyer(mediator);
        Buyer frenchBuyer = new FrenchBuyer(mediator);
        float sellingPriceInDollars = 10.0f;
        AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
        DollarConverter dollarConverter = new DollarConverter(mediator);

        float swedishBidInKronor = 55.0f;
        while (!swedishBuyer.attemptToPurchase(swedishBidInKronor)) {
            swedishBidInKronor += 15.0f;
        }
        Assert.assertEquals(swedishBidInKronor, 85.0f);
        float frenchBidInEuros = 3.0f;
        while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) {
            frenchBidInEuros += 1.5f;
        }
        Assert.assertEquals(frenchBidInEuros, 7.5f);
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
