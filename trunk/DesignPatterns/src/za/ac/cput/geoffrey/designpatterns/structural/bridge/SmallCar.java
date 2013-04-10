/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.bridge;

/**
 *
 * @author geoffrey
 */
public class SmallCar extends Vehicle{

    public SmallCar(Engine engine) {
        this.weightInKilos = 3000;
        this.engine = engine;
    }
    
    @Override
    public void drive() {
        System.out.println("\nThe small car is driving");
        int horsepower = engine.go();
        reportOnSpeed(horsepower);
    }
    
}
