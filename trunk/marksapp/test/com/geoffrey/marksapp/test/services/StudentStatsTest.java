/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.test.services;

import com.geoffrey.marksapp.app.factory.DemographicFactory;
import com.geoffrey.marksapp.app.factory.StudentFactory;
import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Student;
import com.geoffrey.marksapp.services.StudentStatisticService;
import com.geoffrey.marksapp.services.crud.StudentCrudService;
import java.util.HashMap;
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
public class StudentStatsTest {
    
    private StudentCrudService studentCrudService;
    private StudentStatisticService studentStatisticService;
    private static ApplicationContext ctx;
    public StudentStatsTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
     @Test
     public void testMaleStatsService() {
         createStudent("John","Cash");
         createStudent("Obi wan","Kenobi");
         createStudent("Lance","Armstrong");
         studentStatisticService = (StudentStatisticService)ctx.getBean("studentStatisticService");
         int numberOfMaleStudents = studentStatisticService.getNumberOfMaleStudents();
         Assert.assertEquals(3, numberOfMaleStudents,"Male stats passed.");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/marksapp/app/config/applicationContext-*.xml");
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

    private void createStudent(String name, String surname) {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Demographic demographic = DemographicFactory.getDemographic("MALE", "WHITE");
        Map<String, String> values = new HashMap<String, String>();
        values.put("firstName", name);
        values.put("lastName", surname);
        values.put("studentNumber", "20000");
        
        Student student = StudentFactory.getStudent(demographic, values);
        
        studentCrudService.persist(student);
    }
}
