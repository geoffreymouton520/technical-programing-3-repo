/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.factorymethod;

/**
 *
 * @author 211026298
 */
public class AnimalFactory {
    public Animal getAnimal(String type){
        if (type.equals("Canine")){
            return new Dog();
        }else
        {
            return new Cat();
        }
    }
}
