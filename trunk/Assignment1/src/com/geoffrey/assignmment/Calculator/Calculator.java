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
public interface Calculator {

    int calculateFactorial(int factor);
    float largestNumber(float num1, float num2);
    boolean greaterThan(int num1, int num2);
    List<Integer> setUpSequence(List<Integer> tempSeqence);
}
