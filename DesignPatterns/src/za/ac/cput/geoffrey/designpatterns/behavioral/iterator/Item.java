/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.iterator;

/**
 *
 * @author geoffrey
 */
public class Item {
    String name;
    float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
    
}
