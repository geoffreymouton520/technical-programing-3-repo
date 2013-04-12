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
        this.weightInKilos = 600;
        this.engine = engine;
    }
    
    @Override
    public String drive() {
        int horsepower = engine.go();
        return"The small car is driving " + engine + " " + reportOnSpeed(horsepower);
    }
}
