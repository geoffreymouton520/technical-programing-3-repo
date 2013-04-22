/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.app.factory.ExerciseFactory;
import com.geoffrey.gymapp.app.factory.FitnessRoutineFactory;
import com.geoffrey.gymapp.app.factory.WorkoutFactory;
import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.domain.FitnessLevel;
import com.geoffrey.gymapp.domain.FitnessRoutine;
import com.geoffrey.gymapp.domain.MuscleGroup;
import com.geoffrey.gymapp.domain.RoutineItem;
import com.geoffrey.gymapp.domain.RoutineType;
import com.geoffrey.gymapp.domain.Workout;
import com.geoffrey.gymapp.domain.WorkoutItem;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import com.geoffrey.gymapp.services.crud.FitnessRoutineCrudService;
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
public class FitnessRoutineTest {
    private static ApplicationContext ctx;
    private FitnessRoutineCrudService fitnessRoutineCrudService;
    private WorkoutCrudService workoutCrudService;
    private ExerciseCrudService exerciseCrudService;
    private Long workoutID;
    private Long exerciseID;
    private Long fitnessRoutineID;
    
    public FitnessRoutineTest() {
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
    public void createFitnessRoutine() {
        workoutCrudService = (WorkoutCrudService) ctx.getBean("workoutCrudService");
        WorkoutFactory workoutFactory = WorkoutFactory.getInstance();
        
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
        // Exercise persist end
        
        // Workout persist
        List<WorkoutItem> workoutItems = new ArrayList<WorkoutItem>();
        WorkoutItem workoutItem = new WorkoutItem();
        workoutItem.setExercise(exercise);
        
        workoutItems.add(workoutItem);
        
        Workout workout = workoutFactory.getWorkout(FitnessLevel.BEGINNER, 100, 20);
        workout.setWorkoutItems(workoutItems);
        
        workoutCrudService.persist(workout);
        workoutID = workout.getId();
        Assert.assertNotNull(workout);
        // Workout persist end
        
        fitnessRoutineCrudService = (FitnessRoutineCrudService) ctx.getBean("fitnessRoutineCrudService");
        FitnessRoutineFactory fitnessRoutineFactory = FitnessRoutineFactory.getInstance();
        
        FitnessRoutine fitnessRoutine = fitnessRoutineFactory.getFitnessRoutine(FitnessLevel.BEGINNER, "Get Lean", RoutineType.LEAN);
        
        List<RoutineItem> routineItems = new ArrayList<RoutineItem>();
        RoutineItem routineItem = new RoutineItem();
        routineItem.setOrderInRoutine(1);
        routineItem.setWorkout(workout);
        routineItems.add(routineItem);
        
        fitnessRoutine.setRoutineItems(routineItems);
        fitnessRoutineCrudService.persist(fitnessRoutine);
        fitnessRoutineID = fitnessRoutine.getId();
        Assert.assertNotNull(fitnessRoutine);
        
    }
    
    
    @Test(dependsOnMethods ="createFitnessRoutine" )
    public void readFitnessRoutine() {
        fitnessRoutineCrudService = (FitnessRoutineCrudService) ctx.getBean("fitnessRoutineCrudService");
        FitnessRoutine fitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutineID);
        Assert.assertEquals(fitnessRoutine.getName(), "Get Lean");
        
    }
    
    @Test(dependsOnMethods ="readFitnessRoutine" )
    public void updateFitnessRoutine() {
        fitnessRoutineCrudService = (FitnessRoutineCrudService) ctx.getBean("fitnessRoutineCrudService");
        FitnessRoutine fitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutineID);
        fitnessRoutine.setName("Burnout");
        fitnessRoutineCrudService.merge(fitnessRoutine);
        FitnessRoutine updateFitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutineID);
        Assert.assertEquals(updateFitnessRoutine.getName(), "Burnout");
    }
    
    @Test(dependsOnMethods ="updateFitnessRoutine" )
    public void readFitnessRoutines() {
        fitnessRoutineCrudService = (FitnessRoutineCrudService) ctx.getBean("fitnessRoutineCrudService");
        List<FitnessRoutine> fitnessRoutines = fitnessRoutineCrudService.findAll();
        for(FitnessRoutine fitnessRoutine : fitnessRoutines){
            System.out.println(fitnessRoutine.getName());
        }
       Assert.assertTrue(fitnessRoutines.size() > 0);
    }
    
    @Test(dependsOnMethods ="readFitnessRoutines" )
    public void deleteFitnessRoutine() {
        fitnessRoutineCrudService = (FitnessRoutineCrudService) ctx.getBean("fitnessRoutineCrudService");
        FitnessRoutine fitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutineID);
        fitnessRoutineCrudService.remove(fitnessRoutine);
        FitnessRoutine deletedFitnessRoutine = fitnessRoutineCrudService.findById(fitnessRoutineID);
        Assert.assertNull(deletedFitnessRoutine);
        
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
