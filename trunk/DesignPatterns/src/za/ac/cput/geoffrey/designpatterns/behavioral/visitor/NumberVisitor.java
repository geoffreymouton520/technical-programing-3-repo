/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.geoffrey.designpatterns.behavioral.visitor;

import java.util.List;

/**
 *
 * @author geoffrey
 */
public interface NumberVisitor {
    public int visit(TwoElement twoElement);
    public int visit(ThreeElement threeElement);
    public void visit(List<NumberElement> elementList);
}
