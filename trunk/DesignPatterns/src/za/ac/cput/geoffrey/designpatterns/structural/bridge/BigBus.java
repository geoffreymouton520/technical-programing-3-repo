/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.bridge;

/**
 *
 * @author geoffrey
 */
public class BigBus extends Vehicle{

    public BigBus(Engine engine) {
        this.weightInKilos = 3000;
        this.engine = engine;
    }
    
    @Override
    public String drive() {
        int horsepower = engine.go();
        return "The big bus is driving " + engine + " " + reportOnSpeed(horsepower);
    }
    
}
