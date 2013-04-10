/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.prototype;

/**
 *
 * @author geoffrey
 */
public class Dog implements Prototype{

    private String sound;

    public Dog(String sound) {
        this.sound = sound;
    }
    
    @Override
    public Prototype doClone() {
        return new Dog(sound);
    }

    @Override
    public String toString() {
        return "This dog says " + sound;
    }
    
}
