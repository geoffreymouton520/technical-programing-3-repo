/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.creational.singleton;

/**
 *
 * @author 211026298
 */
public class SingletonExample {
    private static SingletonExample singletonExample = null;

    private SingletonExample() {
    }
    
    public static SingletonExample getInstance(){
        if (singletonExample==null) {
            singletonExample = new SingletonExample();
        }
        return singletonExample;
    }
    
    public String sayHello(){
        return("Hello");
    }
}
