/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.decorator;

/**
 *
 * @author geoffrey
 */
public abstract class AnimalDecorator implements Animal{
    Animal animal;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }
    
}
