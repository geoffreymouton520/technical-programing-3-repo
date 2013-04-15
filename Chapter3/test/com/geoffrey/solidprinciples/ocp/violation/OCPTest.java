/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.violation;

import com.geoffrey.solidprinciples.ocp.voilation.Chair;
import com.geoffrey.solidprinciples.ocp.voilation.Crafter;
import com.geoffrey.solidprinciples.ocp.voilation.Table;
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
public class OCPTest {
    
    public OCPTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testOCP() {
        Crafter crafter = new Crafter();
        Table table = new Table("damaged", 5, "oak");
        Chair chair = new Chair("average", 15, "pine");
        
        crafter.refurnishChair(chair);
        crafter.refurnishTable(table);
        
        Assert.assertEquals(chair.getRate(), 25);
        Assert.assertEquals(table.getRate(), 15);
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
