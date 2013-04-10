/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.visitor;

/**
 *
 * @author geoffrey
 */
public interface NumberElement {
    public void accept(NumberVisitor visitor);
}
