/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.domain.Exercise;
import com.geoffrey.gymapp.services.ReadExerciseService;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("readExerciseService")
public class ReadExerciseServiceImpl implements ReadExerciseService{

    @Override
    public Exercise getExerciseByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
