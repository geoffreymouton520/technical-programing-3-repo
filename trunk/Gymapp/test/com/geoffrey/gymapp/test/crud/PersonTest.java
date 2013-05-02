/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.app.factory.PersonFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.services.crud.PersonCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author geoffrey
 */
public class PersonTest {
    private static ApplicationContext ctx;
    private PersonCrudService personCrudService;
    private Long id;
    
    public PersonTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void createPerson() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        PersonFactory personFactory = PersonFactory.getInstance();
        
        Map<String,String> personDetails = new HashMap<String,String>();
        personDetails.put("FirstName", "Geoffrey");
        personDetails.put("LastName", "Mouton");
        personDetails.put("MiddleName", "Gerald");
        
        Date dateOfBirth = new Date(1992,11,23);
        Person person = personFactory.getPerson(personDetails, Gender.MALE, dateOfBirth);
        
        
        personCrudService.persist(person);
        id = person.getId();
        Assert.assertNotNull(person);
        
    }
    
    
    @Test(dependsOnMethods ="createPerson" )
    public void readPerson() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        Person person = personCrudService.findById(id);
        Assert.assertEquals(person.getFirstName(), "Geoffrey");
        
    }
    
    @Test(dependsOnMethods ="readPerson" )
    public void updatePerson() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        Person person = personCrudService.findById(id);
        person.setMiddleName("Legendary");
        personCrudService.merge(person);
        Person updatePerson = personCrudService.findById(id);
        Assert.assertEquals(updatePerson.getMiddleName(), "Legendary");
    }
    
    @Test(dependsOnMethods ="updatePerson" )
    public void readPersons() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        List<Person> persons = personCrudService.findAll();
        for(Person person : persons){
            System.out.println(person.getFirstName());
        }
       Assert.assertTrue(persons.size() > 0);
    }
    
    @Test(dependsOnMethods ="readPersons" )
    public void deletePerson() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        Person person = personCrudService.findById(id);
        personCrudService.remove(person);
        Person deletedPerson = personCrudService.findById(id);
        Assert.assertNull(deletedPerson);
        
        
    }
}
