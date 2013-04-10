/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.proxy;

/**
 *
 * @author geoffrey
 */
public class SlowThing extends Thing{

    public SlowThing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
