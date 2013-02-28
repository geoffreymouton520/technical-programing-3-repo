/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.marksapp.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 211026298
 */
@Embeddable
public class Address implements Serializable {
    private String postalCode;
    private String postalAddressl;
    private String physicalAddress;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalAddressl() {
        return postalAddressl;
    }

    public void setPostalAddressl(String postalAddressl) {
        this.postalAddressl = postalAddressl;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
    
    
}
