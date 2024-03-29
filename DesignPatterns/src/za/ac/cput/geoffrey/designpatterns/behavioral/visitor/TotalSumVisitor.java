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
public class TotalSumVisitor implements NumberVisitor{
    int totalSum = 0;
    @Override
    public int visit(TwoElement twoElement) {
        int sum = twoElement.a + twoElement.b;
        totalSum += sum;
        return sum;
    }

    @Override
    public int visit(ThreeElement threeElement) {
        int sum = threeElement.a + threeElement.b + threeElement.c;
        totalSum += sum;
        return sum;
    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement numberElement : elementList) {
            numberElement.accept(this);
        }
    }

    public int getTotalSum() {
        return totalSum;
    }
    
    
}
