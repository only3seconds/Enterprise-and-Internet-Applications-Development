/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.Lab5;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author thinking
 */
@Named(value = "personBean")
@SessionScoped
public class PersonBean implements Serializable {
    private String name;
    private int age;
    private String message;

    public static  Integer  DEFAULT_AGE;

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
        DEFAULT_AGE = 18;
        this.name = null;
        this.age = DEFAULT_AGE;
        this.message = null;
    }
    
    
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
