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
public class SumVisitor implements NumberVisitor{

    @Override
    public int visit(TwoElement twoElement) {
        return twoElement.a + twoElement.b;
        
    }

    @Override
    public int visit(ThreeElement threeElement) {
        return threeElement.a + threeElement.b + threeElement.c;
    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement numberElement : elementList) {
            numberElement.accept(this);
        }
    }
    
}
