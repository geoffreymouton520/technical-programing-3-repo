/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.srp.violation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author geoffrey
 */
public class SRPTest {
    
    public SRPTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSRP() {
        HRNotifierFactory hRNotifierFactory = HRNotifierFactory.getInstance();
        HRNotifier hRNotifier = hRNotifierFactory.getHRNotifier("Geoffrey Mouton", "Programmer");
        Assert.assertEquals(hRNotifier.hire(), "Geoffrey Mouton, you are hired as a Programmer by the IT department.");
        Assert.assertEquals(hRNotifier.fire(), "Geoffrey Mouton, you are fired from the it department.");
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
