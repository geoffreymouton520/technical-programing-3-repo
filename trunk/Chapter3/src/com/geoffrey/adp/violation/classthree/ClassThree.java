/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.adp.violation.classthree;

import com.geoffrey.adp.violation.classone.ClassOne;

/**
 *
 * @author 211026298
 */
public class ClassThree {
    private String name;
    private String type;
    private ClassOne classOne;

    public ClassThree(String name, String type, ClassOne classOne) {
        this.name = name;
        this.type = type;
        this.classOne = classOne;
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

    public ClassOne getClassOne() {
        return classOne;
    }

    public void setClassOne(ClassOne classOne) {
        this.classOne = classOne;
    }

    @Override
    public String toString() {
        return "ClassThree{" + "name=" + name + ", type=" + type + ", classOne=" + classOne + '}';
    }
    
    
}
