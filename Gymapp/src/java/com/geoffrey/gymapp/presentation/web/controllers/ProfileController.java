/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.controllers;

import com.geoffrey.gymapp.domain.Gender;
import com.geoffrey.gymapp.presentation.web.model.ProfileModel;
import com.geoffrey.gymapp.services.ProfileServices;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author geoffrey
 */
@Controller
public class ProfileController {
    private static ApplicationContext ctx;
    
    @Autowired
    @Qualifier("profileServices")
    private ProfileServices profileServices;
    
    @RequestMapping(value = "private/profile/view")
    public String viewProfile(Model model, Principal principal ){
        String name = principal.getName();
        ProfileModel profileModel = profileServices.getProfile(name);
        model.addAttribute("profile",profileModel);
        return "private/profile/view";
    }
    
    @RequestMapping(value = "private/profile/edit")
    public String editProfile(Model model, Principal principal ){
        String name = principal.getName();
        ProfileModel profileModel = profileServices.getProfile(name);
        model.addAttribute("profile",profileModel);
        model.addAttribute("genders", Gender.values());
        return "private/profile/edit";
    }
    @RequestMapping(value = "private/profile/update", method = RequestMethod.POST)
    public String updateProfile(Model model, @ModelAttribute("profile") ProfileModel profileModel){
        profileServices.updateProfile(profileModel);
        
        ProfileModel updatedProfileModel = profileServices.getProfile(profileModel.getUserName());
        model.addAttribute("profile",updatedProfileModel);
        return "private/profile/view";
    }
}
