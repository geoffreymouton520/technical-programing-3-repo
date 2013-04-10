/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.adapter;

/**
 *
 * @author geoffrey
 */
public class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo{

    @Override
    public double getTemperatureInF() {
        return cToF(temperatureInC);
    }

    @Override
    public void setTemperatureInF(double temperatureInF) {
        this.temperatureInC = fToC(temperatureInF);
    }

    @Override
    public double getTemperatureInC() {
        return temperatureInC;
    }

    @Override
    public void setTemperatureInC(double temperatureInC) {
        this.temperatureInC = temperatureInC;
    }

    private double cToF(double temperatureInC) {
        return ((temperatureInC * 9 / 5)+ 32);
    }

    private double fToC(double temperatureInF) {
        return ((temperatureInF - 32) * 5 / 9);
    }
    
}
