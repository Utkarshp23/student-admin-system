/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

//import javax.ejb.Stateful;
import javax.persistence.Entity;

/**
 *
 * @author hcdc
 */
public class Login {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String username;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String password;

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
