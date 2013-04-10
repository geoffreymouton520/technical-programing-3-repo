/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.state;

/**
 *
 * @author geoffrey
 */
public class Person implements EmotionalState{
    EmotionalState emotionalState;

    public Person(EmotionalState emotionalState) {
        this.emotionalState = emotionalState;
    }

    public void setEmotionalState(EmotionalState emotionalState) {
        this.emotionalState = emotionalState;
    }

    @Override
    public String sayHello() {
        return emotionalState.sayHello();
    }

    @Override
    public String sayGoodbye() {
        return emotionalState.sayGoodbye();
    }
    
}
