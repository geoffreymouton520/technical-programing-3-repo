/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;


import com.geoffrey.gymapp.presentation.web.model.Contact;
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
public class ContactController {
    
    @RequestMapping(value="/addContact", method= RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
        System.out.println("First Name:" + contact.getFirstname() + "Last Name:" + contact.getLastname());
        return "redirect:contacts.html";
    }
    
    @RequestMapping("/contacts")
    public ModelAndView showContacts(){
        return new ModelAndView("contact", "command", new Contact());
    }
}
