/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.abstractfactory;

/**
 *
 * @author 211026298
 */
public class MammalFactory implements SpeciesFactory{

    @Override
    public Animal getAnimal(String type){
        if ("Dog".equals(type)){
            return new Dog();
        }else
        {
            return new Cat();
        }
    }
}
