/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.decorator;

/**
 *
 * @author geoffrey
 */
public class LegDecorator extends AnimalDecorator{

    public LegDecorator(Animal animal) {
        super(animal);
    }
    
    
    @Override
    public void describe() {
        animal.describe();
        System.out.println("I have legs.");
        dance();
    }
    public void dance(){
        System.out.println("I can dance.");
    }
}
