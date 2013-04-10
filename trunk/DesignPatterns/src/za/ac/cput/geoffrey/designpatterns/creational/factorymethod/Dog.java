/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.factorymethod;

/**
 *
 * @author 211026298
 */
public class Dog implements Animal{

    @Override
    public String makeSound() {
        return ("Woof");
    }
    
}
