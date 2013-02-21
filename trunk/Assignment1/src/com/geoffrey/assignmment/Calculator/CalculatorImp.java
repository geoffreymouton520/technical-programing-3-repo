/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.assignmment.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 211026298
 */
public class CalculatorImp implements Calculator {
    private List<Integer> seqence;
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
        return (num1 > num2)?num1:num2;
    }

    @Override
    public boolean greaterThan(int num1, int num2) {
        return (num1 > num2)?true:false;
    }

    @Override
    public List<Integer> setUpSequence(List<Integer> tempSeqence) {
        seqence = new ArrayList<>();
        return seqence = tempSeqence;
    }

}
