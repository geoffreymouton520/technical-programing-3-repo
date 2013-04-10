/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.structural.adapter;

/**
 *
 * @author geoffrey
 */
public interface TemperatureInfo {
    public double getTemperatureInF();
    public void setTemperatureInF(double temperatureInF);
    public double getTemperatureInC();
    public void setTemperatureInC(double temperatureInC);
}
