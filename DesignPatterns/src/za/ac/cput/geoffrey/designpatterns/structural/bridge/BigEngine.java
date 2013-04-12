/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.bridge;

/**
 *
 * @author geoffrey
 */
public class BigEngine implements Engine{

    int horsepower;

    public BigEngine() {
        horsepower = 350;
    }
    
    @Override
    public int go() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "The big engine is running";
    }
    
}
