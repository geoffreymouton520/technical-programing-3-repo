/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.config;

import com.geoffrey.assignmment.Calculator.Calculator;
import com.geoffrey.assignmment.Calculator.CalculatorImp;
import com.geoffrey.assignmment.Calculator.ScientificCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author 211026298
 */
@Configuration
public class AppConfig {
    @Bean(name="calculator")
    public Calculator getCalculatorImp(){
        return new CalculatorImp();
    }
    @Bean(name="scientific")
    public Calculator getTestImp(){
        return new ScientificCalculator();
    }
}
