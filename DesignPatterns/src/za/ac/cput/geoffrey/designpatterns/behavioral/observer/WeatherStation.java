/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.observer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author geoffrey
 */
public class WeatherStation implements WeatherSubject{
    Set<WeatherObserver> weatherObservers;
    int temperature;

    public WeatherStation(int temperature) {
        weatherObservers = new HashSet<>();
        this.temperature = temperature;
    }
    
    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        weatherObservers.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        weatherObservers.remove(weatherObserver);
    }

    @Override
    public void doNotify() {
        Iterator<WeatherObserver> it = weatherObservers.iterator();
        while (it.hasNext()) {
            WeatherObserver weatherObserver = it.next();
            weatherObserver.doUpdate(temperature);
        }
    }

    public String setTemperature(int temperature) {
        this.temperature = temperature;
        doNotify();
        return "Weather station setting temperature to " + temperature;
    }
    
}
