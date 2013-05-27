/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 211026298
 */

public class PasswordEncryptServiceImpl{
    public static String encrypt(String freeText) {
        StringBuffer getString = new StringBuffer();
        try {
            MessageDigest message = MessageDigest.getInstance("MD5", "SUN");
            byte bs[] = freeText.getBytes();
            byte digest[] = message.digest(bs);
            for (int i = 0; i < digest.length; i++) {
                getString.append(Integer.toHexString(0x0100 + (digest[i] & 0x00FF)).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryptServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NoSuchProviderException ex){
            Logger.getLogger(PasswordEncryptServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getString.toString();
    }
    
}
