/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.interpreter;

import java.util.Map;

/**
 *
 * @author geoffrey
 */
public interface Expression {
    public int interpret(Map<String,Expression> variables);
}
