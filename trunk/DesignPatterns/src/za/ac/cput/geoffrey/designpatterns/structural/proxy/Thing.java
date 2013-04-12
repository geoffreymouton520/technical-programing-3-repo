/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.proxy;

/**
 *
 * @author geoffrey
 */
public abstract class Thing {
    public String sayHello(){
        return this.getClass().getSimpleName() + " says howdy" ;
    }
}
