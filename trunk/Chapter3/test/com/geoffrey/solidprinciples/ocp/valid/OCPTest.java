/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.valid;


import java.util.HashMap;
import java.util.Map;
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
        
        Map<String,String> chairValues = new HashMap<>();
        chairValues.put("type", "chair");
        chairValues.put("condition", "average");
        chairValues.put("woodtype", "pine");
        
        Map<String,String> tableValues = new HashMap<>();
        tableValues.put("type", "table");
        tableValues.put("condition", "damaged");
        tableValues.put("woodtype", "oak");
        
        FunitureFactory funitureFactory = FunitureFactory.getInstance();
        Funiture chair = funitureFactory.getFuniture(chairValues, 15);
        Funiture table = funitureFactory.getFuniture(tableValues, 5);
        Crafter crafter = new Crafter();
        
        crafter.refurnishFuniture(chair);
        crafter.refurnishFuniture(table);
        
        Assert.assertEquals(chair.getRate(), 20);
        Assert.assertEquals(table.getRate(), 20);
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
