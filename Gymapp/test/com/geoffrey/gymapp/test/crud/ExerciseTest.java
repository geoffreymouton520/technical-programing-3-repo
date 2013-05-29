/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.services.JPAProcedures;
import com.geoffrey.gymapp.services.AddExerciseService;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
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
public class ExerciseTest {
    private static ApplicationContext ctx;
    private ExerciseCrudService exerciseCrudService;
    private Long id;
    
    //@Autowired
    private static AddExerciseService addExerciseService;
    
    
    public ExerciseTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public void setUpClass() throws Exception {
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
    
    /*@Test
    public void testProcedure() {
        JPAProcedures jPAProcedures = (JPAProcedures)ctx.getBean("procedures");
        int discPercentage = 5;
        //jPAProcedures.findDiscount(20, discPercentage);
        jPAProcedures.createExercise();
        Assert.assertEquals(discPercentage, 5);
        
        
    }*/
    
    @Test
    public void createExercise() {
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        addExerciseService = (AddExerciseService) ctx.getBean("addExerciseService");
        Map<String,String> exerciseDetails = new HashMap<String,String>();
        exerciseDetails.put("Description", "Workout your chest.");
        exerciseDetails.put("Equipment", "Dumbbell, Bench");
        exerciseDetails.put("Instructions", "Work your chest");
        exerciseDetails.put("Name", "Dumbbell Bench Press");
        
        
        Exercise exercise = addExerciseService.addExercise(exerciseDetails, MuscleGroup.CHEST, 50.0f);
        id = exercise.getId();
        Assert.assertNotNull(exercise);
        
        
    }
    
    
    @Test(dependsOnMethods ="createExercise" )
    public void readExercise() {
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        Exercise exercise = exerciseCrudService.findById(id);
        Assert.assertEquals(exercise.getDescription(), "Workout your chest.");
        
    }
    
    @Test(dependsOnMethods ="readExercise" )
    public void updateExercise() {
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        Exercise exercise = exerciseCrudService.findById(id);
        exercise.setInstructions("BLA BLA");
        exerciseCrudService.merge(exercise);
        Exercise updateExercise = exerciseCrudService.findById(id);
        Assert.assertEquals(updateExercise.getInstructions(), "BLA BLA");
    }
    
    @Test(dependsOnMethods ="updateExercise" )
    public void readExercises() {
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        List<Exercise> exercises = exerciseCrudService.findAll();
        for(Exercise exercise : exercises){
            System.out.println(exercise.getName());
        }
        Assert.assertTrue(exercises.size() > 0);
    }
    
    @Test(dependsOnMethods ="readExercises" )
    public void deleteExercise() {
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        Exercise exercise = exerciseCrudService.findById(id);
        exerciseCrudService.remove(exercise);
        Exercise deletedExercise = exerciseCrudService.findById(id);
        Assert.assertNull(deletedExercise);
    }
}
