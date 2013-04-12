/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.structural;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.structural.decorator.Animal;
import za.ac.cput.geoffrey.designpatterns.structural.decorator.GrowlDecorator;
import za.ac.cput.geoffrey.designpatterns.structural.decorator.LegDecorator;
import za.ac.cput.geoffrey.designpatterns.structural.decorator.LivingAnimal;
import za.ac.cput.geoffrey.designpatterns.structural.decorator.WingDecorator;

/**
 *
 * @author geoffrey
 */
public class DecoratorTest {

    public DecoratorTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
        Animal animal = new LivingAnimal();
        Assert.assertEquals(animal.describe(), "I am an animal.");
        
        animal = new LegDecorator(animal);
        Assert.assertEquals(animal.describe(), "I am an animal. "
                + "I have legs. "
                + "I can dance.");

        animal = new WingDecorator(animal);
        Assert.assertEquals(animal.describe(), "I am an animal. "
                + "I have legs. "
                + "I can dance. "
                + "I have wings. "
                + "I can fly.");

        animal = new GrowlDecorator(animal);
        animal = new GrowlDecorator(animal);
        Assert.assertEquals(animal.describe(), "I am an animal. "
                + "I have legs. "
                + "I can dance. "
                + "I have wings. "
                + "I can fly. "
                + "Grrrrr. "
                + "Grrrrr.");
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
