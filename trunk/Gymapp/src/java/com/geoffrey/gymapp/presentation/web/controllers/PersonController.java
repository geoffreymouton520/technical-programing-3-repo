/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import com.geoffrey.gymapp.services.crud.PersonCrudService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geoffrey
 */
@Controller
public class PersonController {
    private ApplicationContext ctx;
    private PersonCrudService personCrudService;
    private PersonConvertModelToDomain personConvertModelToDomain;
    
    
    
    
    @RequestMapping(value="/addPerson")
    public String addPerson() {
        return "person";
        //return new ModelAndView("person", "command", new Person());
    }
    
    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("person") PersonModel personModel){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        Person person = personConvertModelToDomain.convertToPerson(personModel);
        personCrudService.persist(person);
        return "persons";
    }
    
    @RequestMapping(value = "/persons")
    public String showPersons(Model model){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        List<Person> persons = personCrudService.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }
    
    @RequestMapping(value = "/editPerson")
    public String editPerson(Model model,@RequestParam("person") long personId){
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        Person person = personCrudService.findById(personId);
        model.addAttribute("person", person);
        return "editPerson";
    }
    
    
}
