/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Person;
import com.geoffrey.gymapp.presentation.web.model.PersonModel;

/**
 *
 * @author geoffrey
 */
public interface PersonConvertModelToDomain {
    public Person convertToPerson(PersonModel personModel);
}
