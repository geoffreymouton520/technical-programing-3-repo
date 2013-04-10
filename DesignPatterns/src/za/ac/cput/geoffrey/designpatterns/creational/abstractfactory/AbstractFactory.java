/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.abstractfactory;

/**
 *
 * @author 211026298
 */
public class AbstractFactory {
    public SpeciesFactory getSpeciesFactory(String type){
        if (type.equals("Mammal")){
            return new MammalFactory();
        }else
        {
            return new ReptileFactory();
        }
    }
}
