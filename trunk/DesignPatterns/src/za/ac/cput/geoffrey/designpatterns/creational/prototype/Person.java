/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.prototype;

/**
 *
 * @author geoffrey
 */
public class Person implements Prototype{

    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public Prototype doClone() {
        return new Person(name);
    }

    @Override
    public String toString() {
        return "This person is named " + name;
    }
    
    
    
}
