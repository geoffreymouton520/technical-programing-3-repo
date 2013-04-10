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
public class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Minus(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }
 
    @Override
    public int interpret(Map<String,Expression> variables)  { 
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}
