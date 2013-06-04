/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.presentation.web.model.PreferenceModel;

/**
 *
 * @author geoffrey
 */
public interface PreferenceConvertModelToDomain {

    public Preferences convertToPreference(PreferenceModel preferenceModel);
    
}
