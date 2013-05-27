/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cput.geoffrey.designpatterns.test.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.geoffrey.designpatterns.behavioral.iterator.Item;
import za.ac.cput.geoffrey.designpatterns.behavioral.iterator.Menu;

/**
 *
 * @author geoffrey
 */
public class IteratorTest {

    public IteratorTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void test() {

        Item i1 = new Item("spaghetti", 7.50f);
        Item i2 = new Item("hamburger", 6.00f);
        Item i3 = new Item("chicken sandwich", 6.50f);
        
        List<String> listOfItemsToString = new ArrayList<String>();
        listOfItemsToString.add("spaghetti: $7.5");
        listOfItemsToString.add("hamburger: $6.0");
        listOfItemsToString.add("chicken sandwich: $6.5");
        
        Menu menu = new Menu();
        menu.addItem(i1);
        menu.addItem(i2);

        Iterator<Item> iterator = menu.iterator();
        Iterator<String> toStringIterator = listOfItemsToString.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            String itemToString = toStringIterator.next();
            Assert.assertEquals(item.toString(), itemToString);
        }
        
        iterator.remove();
        toStringIterator.remove();
        
        iterator = menu.iterator();
        toStringIterator = listOfItemsToString.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            String itemToString = toStringIterator.next();
            Assert.assertEquals(item.toString(), itemToString);
        }
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
