/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.behavioral;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.NumberElement;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.NumberVisitor;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.SumVisitor;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.ThreeElement;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.TotalSumVisitor;
import za.ac.cput.geoffrey.designpatterns.behavioral.visitor.TwoElement;

/**
 *
 * @author geoffrey
 */
public class VisitorTest {

    public VisitorTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        TwoElement two1 = new TwoElement(3, 3);
        TwoElement two2 = new TwoElement(2, 7);
        ThreeElement three1 = new ThreeElement(3, 4, 5);

        List<NumberElement> numberElements = new ArrayList<>();
        numberElements.add(two1);
        numberElements.add(two2);
        numberElements.add(three1);

        NumberVisitor sumVisitor = new SumVisitor();
        sumVisitor.visit(numberElements);
                
        System.out.println("\nVisiting element list with TotalSumVisitor");
        TotalSumVisitor totalSumVisitor = new TotalSumVisitor();
        totalSumVisitor.visit(numberElements);
        Assert.assertEquals(totalSumVisitor.getTotalSum(),27);
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
