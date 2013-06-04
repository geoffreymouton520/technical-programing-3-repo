/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.PreferencesFactory;
import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.domain.MeasuringUnit;
import com.geoffrey.gymapp.domain.Preferences;
import com.geoffrey.gymapp.presentation.web.model.PreferenceModel;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.PreferenceConvertModelToDomain;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("preferenceConvertModelToDomain")
public class PreferenceConvertModelToDomainImpl implements PreferenceConvertModelToDomain{

    @Override
    public Preferences convertToPreference(PreferenceModel preferenceModel) {
        PreferencesFactory preferencesFactory = PreferencesFactory.getInstance();
        MeasuringUnit measuringUnit = MeasuringUnit.valueOf(preferenceModel.getMeasuringUnit());
        int time = Integer.parseInt(preferenceModel.getRestTimeInSeconds());
        Preferences preferences = preferencesFactory.getPreferences(measuringUnit,time);
        return preferences;
    }
    
}
