/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.presentation.web.model.Contact;
import com.geoffrey.gymapp.presentation.web.model.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author geoffrey
 */
@Controller
public class ExerciseController {
    @RequestMapping(value="/addExercise", method= RequestMethod.POST)
    public String addContact(@ModelAttribute("exercise") Exercise exercise, BindingResult result){
        //String result = createNewExercise(exercise);
        return "redirect:contacts.html";
    }
    
    @RequestMapping("/contacts")
    public ModelAndView showContacts(){
        return new ModelAndView("contact", "command", new Contact());
    }
}
