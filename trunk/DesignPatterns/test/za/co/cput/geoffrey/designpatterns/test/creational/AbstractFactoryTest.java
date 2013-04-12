/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.creational;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.creational.abstractfactory.AbstractFactory;
import za.ac.cput.geoffrey.designpatterns.creational.abstractfactory.Animal;
import za.ac.cput.geoffrey.designpatterns.creational.abstractfactory.SpeciesFactory;

/**
 *
 * @author geoffrey
 */
public class AbstractFactoryTest {

    public AbstractFactoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {
        AbstractFactory abstractFactory = new AbstractFactory();

        SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory("Reptile");
        Animal a1 = speciesFactory1.getAnimal("Tyrannosaurus");
        Assert.assertEquals(a1.makeSound(), "Roar");
        
        Animal a2 = speciesFactory1.getAnimal("Snake");
        Assert.assertEquals(a2.makeSound(), "Hiss");

        SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory("Mammal");
        Animal a3 = speciesFactory2.getAnimal("Dog");
        Assert.assertEquals(a3.makeSound(), "Woof");
        Animal a4 = speciesFactory2.getAnimal("Cat");
        Assert.assertEquals(a4.makeSound(), "Meow");
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
