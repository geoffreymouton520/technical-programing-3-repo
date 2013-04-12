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
import za.ac.cput.geoffrey.designpatterns.behavioral.interpreter.AndExpression;
import za.ac.cput.geoffrey.designpatterns.behavioral.interpreter.Expression;
import za.ac.cput.geoffrey.designpatterns.behavioral.interpreter.OrExpression;
import za.ac.cput.geoffrey.designpatterns.behavioral.interpreter.TerminalExpression;

/**
 *
 * @author geoffrey
 */
public class InterpreterTest {

    public InterpreterTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        Expression isMale = new OrExpression(robert, john);
        
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        Expression isMarriedWoman = new AndExpression(julie, married);
        
        Assert.assertTrue(isMale.interpret("John"));
        Assert.assertTrue(isMarriedWoman.interpret("Married Julie"));
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
