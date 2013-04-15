/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.adp.violation.classone;

import com.geoffrey.adp.violation.classthree.ClassThree;

/**
 *
 * @author 211026298
 */
public class ClassOne {
    private String name;
    private String type;
    private ClassThree classThree;

    public ClassOne(String name, String type, ClassThree classThree) {
        this.name = name;
        this.type = type;
        this.classThree = classThree;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClassThree getClassThree() {
        return classThree;
    }

    public void setClassThree(ClassThree classThree) {
        this.classThree = classThree;
    }

    @Override
    public String toString() {
        return "ClassOne{" + "name=" + name + ", type=" + type + ", classThree=" + classThree + '}';
    }
    
}
