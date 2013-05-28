/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;
import com.geoffrey.gymapp.services.PersonConvertModelToDomain;
import com.geoffrey.gymapp.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    @Qualifier("personService")
    private PersonService personService;
    
    @Autowired
    @Qualifier("personConvertModelToDomain")
    private PersonConvertModelToDomain personConvertModelToDomain;
    
    @RequestMapping(value="private/person/add")
    public String addPerson() {
        return "private/person/add";
    }
    
    @RequestMapping(value = "private/person/save", method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("person") PersonModel personModel){
        //ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        //personService = (PersonCrudService) ctx.getBean("personService");
        //personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        Person person = personConvertModelToDomain.convertToPerson(personModel);
        personService.addPerson(person);
        
        List<Person> persons = personService.getPeople();
        model.addAttribute("persons", persons);
        return "private/person/all";
    }
    
    @RequestMapping(value = "private/person/all")
    public String showPersons(Model model){
        //ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        //personService = (PersonCrudService) ctx.getBean("personService");
        //personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        List<Person> persons = personService.getPeople();
        model.addAttribute("persons", persons);
        return "private/person/all";
    }
    
    @RequestMapping(value = "private/person/edit")
    public String editPerson(Model model,@RequestParam("personID") long personId){
        //ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        //personService = (PersonCrudService) ctx.getBean("personService");
        //personConvertModelToDomain = (PersonConvertModelToDomain) ctx.getBean("personConvertModelToDomain");
        
        Person person = personService.getPersonByID(personId);
        model.addAttribute("person", person);
        return "private/person/edit";
    }
    
    @RequestMapping(value = "private/person/update")
    public String updateExercise(Model model,@ModelAttribute("person") PersonModel personModel){
        Person person = personConvertModelToDomain.convertToPerson(personModel);
        personService.updatePerson(person);
        
        List<Person> persons = personService.getPeople();
        model.addAttribute("persons", persons);
        return "private/person/all";
    }
    
    @RequestMapping(value = "private/person/delete")
    public String deleteExercise(Model model,@RequestParam("personID") long personId){
        personService.deletePerson(personId);
        
        List<Person> persons = personService.getPeople();
        model.addAttribute("persons", persons);
        return "private/person/all";
    }
}
