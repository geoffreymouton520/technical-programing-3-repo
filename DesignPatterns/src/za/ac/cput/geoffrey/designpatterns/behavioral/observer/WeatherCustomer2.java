/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.observer;

/**
 *
 * @author geoffrey
 */
public class WeatherCustomer2 implements WeatherObserver{

    @Override
    public String doUpdate(int temperature) {
        return "Weather customer 2 just found out the temperature is:" + temperature;
    }
    
}
