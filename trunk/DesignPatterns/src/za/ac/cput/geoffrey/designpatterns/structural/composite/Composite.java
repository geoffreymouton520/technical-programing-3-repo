/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public class Composite implements Component{

    List<Component> components = new ArrayList<>();
    
    @Override
    public String sayHello() {
        String hello = "";
        for (Component component : components) {
            hello += component.sayHello();
        }
        return hello;
    }

    @Override
    public String sayGoodbye() {
        String goodbye = "";
        for (Component component : components) {
            goodbye += component.sayGoodbye();
        }
        return goodbye;
    }
    
    public void add(Component component){
        components.add(component);
    }
    
    public void remove(Component component){
        components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }
    
    public Component getComponent(int index){
        return components.get(index);
    }
}
