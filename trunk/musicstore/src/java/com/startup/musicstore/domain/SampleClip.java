/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author geoffrey
 */
@Embeddable
public class SampleClip implements Serializable{
    private String sampleUrl;

    public String getSampleUrl() {
        return sampleUrl;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }
    
}
