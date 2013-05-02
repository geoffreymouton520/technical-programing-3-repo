/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.app.factory.ExerciseFactory;
import com.geoffrey.gymapp.app.factory.WorkoutFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.domain.WorkoutItem;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import com.geoffrey.gymapp.services.crud.WorkoutCrudService;
import java.util.ArrayList;
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
public class WorkoutTest {
    private static ApplicationContext ctx;
    private WorkoutCrudService workoutCrudService;
    private ExerciseCrudService exerciseCrudService;
    private Long workoutID;
    private Long exerciseID;
    
    public WorkoutTest() {
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
    public void createWorkout() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        WorkoutFactory workoutFactory = WorkoutFactory.getInstance();
        
        List<WorkoutItem> workoutItems = new ArrayList<WorkoutItem>();
        
        // Exercise persist
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        ExerciseFactory exerciseFactory = ExerciseFactory.getInstance();
        
        Map<String,String> exerciseDetails = new HashMap<String,String>();
        exerciseDetails.put("Description", "Workout your chest.");
        exerciseDetails.put("Equipment", "Dumbbell, Bench");
        exerciseDetails.put("Instructions", "Work your chest");
        exerciseDetails.put("Name", "Dumbbell Bench Press");
        
        Exercise exercise = exerciseFactory.getExercise(exerciseDetails, MuscleGroup.CHEST, 50.0f);
        exerciseCrudService.persist(exercise);
        exerciseID = exercise.getId();
        Assert.assertNotNull(exercise);
        
        WorkoutItem workoutItem = new WorkoutItem();
        workoutItem.setExercise(exercise);
        
        workoutItems.add(workoutItem);
        
        Workout workout = workoutFactory.getWorkout(FitnessLevel.BEGINNER, 100, 20);
        workout.setWorkoutItems(workoutItems);
        
        workoutCrudService.persist(workout);
        workoutID = workout.getId();
        Assert.assertNotNull(workout);
        
    }
    
    
    @Test(dependsOnMethods ="createWorkout" )
    public void readWorkout() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        Workout workout = workoutCrudService.findById(workoutID);
        Assert.assertEquals(workout.getFitnessLevel(), FitnessLevel.BEGINNER);
        
    }
    
    @Test(dependsOnMethods ="readWorkout" )
    public void updateWorkout() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        Workout workout = workoutCrudService.findById(workoutID);
        workout.setFitnessLevel(FitnessLevel.INTERMEDIATE);
        workoutCrudService.merge(workout);
        Workout updateWorkout = workoutCrudService.findById(workoutID);
        Assert.assertEquals(updateWorkout.getFitnessLevel(), FitnessLevel.INTERMEDIATE);
    }
    
    @Test(dependsOnMethods ="updateWorkout" )
    public void readWorkouts() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        List<Workout> workouts = workoutCrudService.findAll();
        for(Workout workout : workouts){
            System.out.println(workout.getTotalCaloriesBurned());
        }
       Assert.assertTrue(workouts.size() > 0);
    }
    
    @Test(dependsOnMethods ="readWorkouts" )
    public void deleteWorkout() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        Workout workout = workoutCrudService.findById(workoutID);
        workoutCrudService.remove(workout);
        Workout deletedWorkout = workoutCrudService.findById(workoutID);
        Assert.assertNull(deletedWorkout);
        
        exerciseCrudService = (ExerciseCrudService) ctx.getBean("exerciseCrudService");
        Exercise exercise = exerciseCrudService.findById(exerciseID);
        exerciseCrudService.remove(exercise);
        Exercise deletedExercise = exerciseCrudService.findById(exerciseID);
        Assert.assertNull(deletedExercise);
    }
}
