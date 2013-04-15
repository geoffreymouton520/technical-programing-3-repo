/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.srp.valid;


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
        NotifierFactory notifierFactory = NotifierFactory.getInstance();
        Employee employee = new Employee("Geoffrey", "Mouton", "Programmer");
        Notifier notifier = notifierFactory.getNotifier(employee);
        Assert.assertEquals(notifier.sendNotification("hire"), "Geoffrey Mouton, you are hired as a Programmer by the IT department.");
        Assert.assertEquals(notifier.sendNotification("fire"), "Geoffrey Mouton, you are fired from the it department.");
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
