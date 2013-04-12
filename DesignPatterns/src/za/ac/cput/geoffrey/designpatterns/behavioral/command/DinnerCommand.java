/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.command;

/**
 *
 * @author geoffrey
 */
public class DinnerCommand implements Command{
    Dinner dinner;

    public DinnerCommand(Dinner dinner) {
        this.dinner = dinner;
    }

    @Override
    public String execute() {
        return dinner.makeDinner();
    }
    
}
