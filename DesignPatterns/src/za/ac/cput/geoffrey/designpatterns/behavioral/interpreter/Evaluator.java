/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 *
 * @author geoffrey
 */
public class Evaluator implements Expression {
    private Expression syntaxTree;
 
    public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<>();
        for (String token : expression.split(" ")) {
            switch (token) {
                case "+":
                    {
                        Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                        expressionStack.push( subExpression );
                        break;
                    }
                case "-":
                    {
                        // it's necessary remove first the right operand from the stack
                        Expression right = expressionStack.pop();
                        // ..and after the left one
                        Expression left = expressionStack.pop();
                        Expression subExpression = new Minus(left, right);
                        expressionStack.push( subExpression );
                        break;
                    }
                default:
                    expressionStack.push( new Variable(token) );
                    break;
            }
        }
        syntaxTree = expressionStack.pop();
    }
 
    @Override
    public int interpret(Map<String,Expression> context) {
        return syntaxTree.interpret(context);
    }
}
