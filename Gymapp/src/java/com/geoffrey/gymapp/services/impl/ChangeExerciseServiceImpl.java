/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.services.ChangeExerciseService;
import com.geoffrey.gymapp.services.crud.ExerciseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("readExerciseService")
public class ChangeExerciseServiceImpl implements ChangeExerciseService{

    @Autowired
    public ExerciseCrudService exerciseCrudService;
    
    @Override
    public Exercise setExerciseName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
