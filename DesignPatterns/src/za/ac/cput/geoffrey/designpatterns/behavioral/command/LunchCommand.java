/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.command;

/**
 *
 * @author geoffrey
 */
public class LunchCommand implements Command{
    Lunch lunch;

    public LunchCommand(Lunch lunch) {
        this.lunch = lunch;
    }

    @Override
    public String execute() {
        return lunch.makeLunch();
    }
    
}
