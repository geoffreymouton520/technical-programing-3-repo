/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.assignmment.Calculator;

import java.util.List;

/**
 *
 * @author 211026298
 */
public class IntegerImp implements Calculator {
    
    @Override
    public int calculateFactorial(int factor){
        int factorial = 1;
        for (int i = 2; i <= factor; i++) {
            factorial *= i; 
        }
        return factorial;
    }

    

    @Override
    public float largestNumber(float num1, float num2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean greaterThan(int num1, int num2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Integer> setUpSequence(List<Integer> tempSeqence) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
