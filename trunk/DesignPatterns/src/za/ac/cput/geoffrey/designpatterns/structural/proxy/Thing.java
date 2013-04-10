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
public abstract class Thing {
    public void sayHello(){
        System.out.println(this.getClass().getSimpleName() + " says howdy at " + new Date());
    }
}
