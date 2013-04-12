/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.flyweight;

/**
 *
 * @author geoffrey
 */
public class FlyweightAdder implements Flyweight{
    String operation;

    public FlyweightAdder() {
        operation = "adding";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int doMath(int a, int b) {
        return a + b;
    }
}
