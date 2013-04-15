/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.solidprinciples.ocp.valid;

import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class FunitureFactory {
    private static FunitureFactory funitureFactory = null;

    private FunitureFactory() {
    }
    
    public static FunitureFactory getInstance(){
        if (funitureFactory == null) {
            funitureFactory = new FunitureFactory();
        }
        return funitureFactory;
    }
    
    public Funiture getFuniture(Map<String,String> values, int rate){
        if (values.get("type").equals("chair")) {
            return new Chair(values.get("condition"), rate, values.get("woodtype"));
        } else {
            return new Table(values.get("condition"), rate, values.get("woodtype"));
        }
    }
}
