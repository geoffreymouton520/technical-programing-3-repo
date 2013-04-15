/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.adp.valid.classone;

import com.geoffrey.adp.valid.classoneextension.ClassOneExtension;
import com.geoffrey.adp.violation.classone.*;
import com.geoffrey.adp.violation.classthree.ClassThree;

/**
 *
 * @author 211026298
 */
public class ClassOne {
    private String name;
    private String type;
    private ClassOneExtension classOneExtension;

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

    public ClassOneExtension getClassOneExtension() {
        return classOneExtension;
    }

    public void setClassOneExtension(ClassOneExtension classOneExtension) {
        this.classOneExtension = classOneExtension;
    }

    @Override
    public String toString() {
        return "ClassOne{" + "name=" + name + ", type=" + type + ", classOneExtension=" + classOneExtension + '}';
    }

    
}
