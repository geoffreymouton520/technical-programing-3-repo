/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.hello.test;

import com.geoffrey.hello.HelloWorld;
import com.geoffrey.hello.HelloWorldImp;
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
public class HelloWorldTest {
    
    private HelloWorld helloWorld;
    public HelloWorldTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testHelloWorld() 
    {
        helloWorld = new HelloWorldImp();
        String hello = helloWorld.getString();
        Assert.assertEquals(hello, "Hello World");
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
