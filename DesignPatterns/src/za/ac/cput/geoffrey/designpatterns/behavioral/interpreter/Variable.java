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
public class Variable implements Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        if (null == variables.get(name)) {
            return 0; //Either return new Number(0).
        }
        return variables.get(name).interpret(variables);
    }
}
