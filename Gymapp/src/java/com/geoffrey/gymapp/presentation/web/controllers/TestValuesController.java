/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.services.JPAProcedures;
import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 211026298
 */
@Controller
public class TestValuesController {

    private ApplicationContext ctx;
    private JPAProcedures jPAProcedures;


    @RequestMapping(value = "/private/testvalues/runPart1")
    public String Part1(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        jPAProcedures = (JPAProcedures)ctx.getBean("procedures");
        String result;
        try {
         result = jPAProcedures.insertTestValues();
        } catch (Exception e) {
            result = "Unsuccessful";
        }
        model.addAttribute("result", result);
        return "private/testvalues/runPart1";
    }
    
    @RequestMapping(value = "/private/testvalues/runPart2")
    public String Part2(Model model) {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        jPAProcedures = (JPAProcedures)ctx.getBean("procedures");
        String result;
        try {
            result = jPAProcedures.insertTestPart2Values();
        } catch (Exception e) {
            result = "Unsuccessful";
        }
        
        model.addAttribute("result", result);
        return "private/testvalues/runPart2";
    }
}
