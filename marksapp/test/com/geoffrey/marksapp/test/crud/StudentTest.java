/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.test.crud;


import com.geoffrey.marksapp.app.factory.DemographicFactory;
import com.geoffrey.marksapp.app.factory.StudentFactory;
import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Student;
import com.geoffrey.marksapp.services.crud.StudentCrudService;
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
 * @author boniface
 */
public class StudentTest {
    
    private StudentCrudService studentCrudService;
    private Long id;
    private static ApplicationContext ctx;
    
    public StudentTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStudent() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Demographic demographic = DemographicFactory.getDemographic("MALE", "WHITE");
        Map<String, String> values = new HashMap<String, String>();
        values.put("firstName", "Phil");
        values.put("lastName", "Phiri");
        values.put("studentNumber", "20000");
        
        Student student = StudentFactory.getStudent(demographic, values);
        
        studentCrudService.persist(student);
        id = student.getId();
        Assert.assertNotNull(student);
        
    }
    
    @Test
    public void createSecondStudent() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Demographic demographic = DemographicFactory.getDemographic("MALE", "WHITE");
        Map<String, String> values = new HashMap<String, String>();
        values.put("firstName", "John");
        values.put("lastName", "Phiri");
        values.put("studentNumber", "20000");
        
        Student student = StudentFactory.getStudent(demographic, values);
        
        studentCrudService.persist(student);
        id = student.getId();
        Assert.assertNotNull(student);
        
    }
    @Test(dependsOnMethods ="createStudent" )
    public void readStudent() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Student student = studentCrudService.findById(id);
        Assert.assertEquals(student.getLastName(), "Phiri");
        
    }
    
    @Test(dependsOnMethods ="readStudent" )
    public void updateStudent() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Student student = studentCrudService.findById(id);
        student.setFirstName("Peter");
        studentCrudService.merge(student);
        Student updateStudent = studentCrudService.findById(id);
        Assert.assertEquals(updateStudent.getFirstName(), "Peter");
    }
    
    @Test(dependsOnMethods ="updateStudent" )
    public void readStudents() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        List<Student> students = studentCrudService.findAll();
        for(Student student : students){
            System.out.println(student.getFirstName());
        }
       Assert.assertTrue(students.size() > 0);
    }
    
   /* @Test(dependsOnMethods ="readStudents" )
    public void deleteStudent() {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        Student student = studentCrudService.findById(id);
        studentCrudService.remove(student);
        Student deletedStudent = studentCrudService.findById(id);
        Assert.assertNull(deletedStudent);
        
        
    }*/
}