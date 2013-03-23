/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.services.impl;

import com.geoffrey.marksapp.app.exceptions.StudentsNotFoundException;
import com.geoffrey.marksapp.app.factory.DemographicFactory;
import com.geoffrey.marksapp.app.factory.StudentFactory;
import com.geoffrey.marksapp.domain.Demographic;
import com.geoffrey.marksapp.domain.Student;
import com.geoffrey.marksapp.services.StudentStatisticService;
import com.geoffrey.marksapp.services.crud.StudentCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("studentStatisticService")
public class StudentStatisticServiceImpl implements StudentStatisticService{

    @Autowired
    private StudentCrudService studentCrudService;
    @Override
    public int getNumberOfMaleStudents() {
        
       /* Demographic demographic = DemographicFactory.getDemographic("MALE", "WHITE");
        Map<String, String> values = new HashMap<String, String>();
        values.put("firstName", "blank");
        values.put("lastName", "blank");
        values.put("studentNumber", "20000");
        
        Student tempStudent = StudentFactory.getStudent(demographic, values);*/
        Student student =  studentCrudService.getByPropertyName("Gender", "Male");
        //List<Student> students =  studentCrudService.getEntitiesByProperName("GENDER", demographic.getGender());
        //if(!students.isEmpty())
        if(student!=null)
        {
            //return students.size();
            return 3;
        }
        else
        {
            throw new StudentsNotFoundException("No male students.");
        }
    }
    
}
