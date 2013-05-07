/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Exercise;

/**
 *
 * @author 211026298
 */
public interface ReadExerciseService {
    public Exercise findById(long id);
    public Exercise findByName(String Name);
}
