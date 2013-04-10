/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.state;

/**
 *
 * @author geoffrey
 */
public class HappyState implements EmotionalState{

    @Override
    public String sayHello() {
        return "Hello, friend!";
    }

    @Override
    public String sayGoodbye() {
        return "Bye, friend!";
    }
    
}
