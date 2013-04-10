/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.command;

/**
 *
 * @author geoffrey
 */
public class MealInvoker {
    Command command;

    public MealInvoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    public void invoke(){
        command.execute();
    }
}
