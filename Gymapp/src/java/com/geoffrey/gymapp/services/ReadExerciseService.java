/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Exercise;

/**
 *
 * @author geoffrey
 */
public interface ReadExerciseService {
    public Exercise getExerciseByName(String name);
}
