/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.assignmment.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public class MiscImp implements Calculator{
    @Override
    public int calculateFactorial(int factor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float largestNumber(float num1, float num2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public boolean greaterThan(int num1, int num2) {
        return (num1 > num2)?true:false;
    }

    @Override
    public List<Integer> setUpSequence(List<Integer> tempSeqence) {
        return tempSeqence;
    }

    
}
