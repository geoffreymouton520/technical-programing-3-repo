/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.abstractfactory;

/**
 *
 * @author 211026298
 */
public interface SpeciesFactory {
    public Animal getAnimal(String type);
}
