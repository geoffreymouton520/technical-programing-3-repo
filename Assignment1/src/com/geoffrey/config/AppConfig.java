/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.config;

import com.geoffrey.assignmment.Calculator.Calculator;
import com.geoffrey.assignmment.Calculator.FloatImp;
import com.geoffrey.assignmment.Calculator.IntegerImp;
import com.geoffrey.assignmment.Calculator.MiscImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author 211026298
 */
@Configuration
public class AppConfig {
    @Bean(name="interger")
    public Calculator getIntegerImp(){
        return new IntegerImp();
    }
    
    @Bean(name="float")
    public Calculator getFloatImp(){
        return new FloatImp();
    }
    
    @Bean(name="misc")
    public Calculator getMiscImp(){
        return new MiscImp();
    }
    
}
