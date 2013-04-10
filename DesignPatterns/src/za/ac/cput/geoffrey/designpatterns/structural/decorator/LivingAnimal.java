/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.decorator;

/**
 *
 * @author geoffrey
 */
public class LivingAnimal implements Animal{

    @Override
    public void describe() {
        System.out.println("\nI am an animal.");
    }
    
}
