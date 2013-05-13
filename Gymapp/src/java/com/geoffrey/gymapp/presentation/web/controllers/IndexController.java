/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author geoffrey
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String home(Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }
}
