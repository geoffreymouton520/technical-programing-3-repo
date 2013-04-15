/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.crp.violation;

import com.geoffrey.tdd.part1.*;
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
public class CRPTest {
    
    public CRPTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCRP() {
        HeroFactory heroFactory = HeroFactory.getInstance();
        Hero majesticHero = heroFactory.getHero("majestic", "Superman", "Da da da daaa");
        Assert.assertEquals(majesticHero.chargeIn(), "I either fly supersonic or run faster than light");
        
        Hero betaHero = heroFactory.getHero("beta", "Flash", "Be back in a flash");
        Assert.assertEquals(betaHero.chargeIn(), "I can run faster than speeding bullet");
        
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
