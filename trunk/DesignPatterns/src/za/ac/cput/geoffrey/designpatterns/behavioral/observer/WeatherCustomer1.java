/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.observer;

/**
 *
 * @author geoffrey
 */
public class WeatherCustomer1 implements WeatherObserver{

    @Override
    public void doUpdate(int temperature) {
        System.out.println("\nWeather customer 1 just found out the temperature is:" + temperature);
    }
    
}
