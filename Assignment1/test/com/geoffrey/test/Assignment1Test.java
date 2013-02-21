/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.test;

import com.geoffrey.assignmment.Calculator.Calculator;
import com.geoffrey.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author 211026298
 */
public class Assignment1Test {
    private static Calculator calculator;
    private static Calculator scifiCalculator;
    private static ApplicationContext ctx;
    public Assignment1Test() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLargest() {
        Assert.assertEquals(calculator.largestNumber((float)5.78, (float)5.79), (float)5.79, "Largest failed");
    }
    
    @Test
    public void testFactorial() {
        Assert.assertEquals(calculator.calculateFactorial(5), 120, "Factorial failed");
    }
    
    @Test
    public void testCalculatorEuality() {
        Calculator tempCalculator = (Calculator)ctx.getBean("calculator");
        Assert.assertEquals(calculator, tempCalculator,"Objects are not equal");
    }
    @Test
    public void testCalculatorIdentity() {
        Calculator tempCalculator = (Calculator)ctx.getBean("calculator");
        Assert.assertSame(calculator, tempCalculator, "Objects are not the same instance");
    }
    
    @Test
    public void testGreaterThan() {
        Assert.assertTrue(calculator.greaterThan(2, 1), "It is greater than");
    }
    
    @Test
    public void testLessThan() {
        Assert.assertFalse(calculator.greaterThan(1, 2), "It is less than or equal to");
    }
    
    @Test
    public void testDelibrateFail() {
        Assert.fail("Testing delibrate fail");
    }
    
    @Test(timeOut=1)
    public void testTimeout() {
        Assert.assertTrue(calculator.greaterThan(2, 1),"Test took longer than a second");
    }
    
    @Test(enabled=false)
    public void testIgnore() {
        Assert.assertSame(calculator, scifiCalculator, "Method is not ready");
    }
    
    @Test
    public void testCollection() {
        List<Integer> tempSeqence;
        tempSeqence = new ArrayList<>();
        tempSeqence.add(1);
        tempSeqence.add(3);
        tempSeqence.add(5);
        tempSeqence.add(7);
        Assert.assertEquals(calculator.setUpSequence(tempSeqence), tempSeqence, "Collection are not the same");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (Calculator)ctx.getBean("calculator");
        scifiCalculator = (Calculator)ctx.getBean("scientific");
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
