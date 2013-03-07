/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.test;

import com.geoffrey.marksapp.app.factory.DemographicFactory;
import com.geoffrey.marksapp.app.factory.LecturerFactory;
import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Lecturer;
import com.geoffrey.marksapp.services.crud.LecturerCrudService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 211026298
 */
public class LecturerTest {
    
    private LecturerCrudService lecturerCrudService;
    private Long id;
    private static ApplicationContext ctx;
    
    public LecturerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/marksapp/app/conf/applicationContext-*.xml");
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
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createLecturer() {
        Demographic demographic = DemographicFactory.getDemographic("Male", "Asian");
        Map<String,String> value = new HashMap<String, String>();
        value.put("firstName", "Kruben");
        value.put("lastName", "Naidoo");
        value.put("staffNumber", "200000");
        Lecturer naidook = LecturerFactory.getLecturer(demographic, value);
        lecturerCrudService = (LecturerCrudService)ctx.getBean("lecturerCrudService");
        lecturerCrudService.persist(naidook);
        id = naidook.getId();
        
        Assert.notNull(naidook);
    }
    
    @Test
    public void readLecturer() {
        lecturerCrudService = (LecturerCrudService)ctx.getBean("lecturerCrudService");
        Lecturer lecturer = lecturerCrudService.findById(id);
        Assert.notNull(lecturer);
    }
    
    @Test
    public void updateLecturer() {
        lecturerCrudService = (LecturerCrudService)ctx.getBean("lecturerCrudService");
        Lecturer lecturer = lecturerCrudService.findById(id);
        lecturer.setStaffNumber("999");
        lecturerCrudService.merge(lecturer);
        Lecturer update = lecturerCrudService.findById(id);
        //Assert.
    }
    
    @Test
    public void readLecturers() {
    }
    
    @Test
    public void deleteLecturer() {
    }
}
