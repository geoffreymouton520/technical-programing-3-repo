/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.proxy;

import java.util.Date;

/**
 *
 * @author geoffrey
 */
public class Proxy {
    SlowThing slowThing;

    public Proxy() {
        System.out.println("Creating proxy at " + new Date());
    }
    public void sayHello(){
        if (slowThing == null) {
            slowThing = new SlowThing();
        }
        slowThing.sayHello();
    }
    
}
