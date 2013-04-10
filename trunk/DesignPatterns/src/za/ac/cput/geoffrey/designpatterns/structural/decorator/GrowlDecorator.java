/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.decorator;

/**
 *
 * @author geoffrey
 */
public class GrowlDecorator extends AnimalDecorator{

    public GrowlDecorator(Animal animal) {
        super(animal);
    }

    
    @Override
    public void describe() {
        animal.describe();
        growl();
    }
    
    public void growl(){
        System.out.println("Grrrrr.");
    }
}
