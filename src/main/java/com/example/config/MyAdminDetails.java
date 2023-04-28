/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import com.example.entities.Admin;
import com.example.entities.Student;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author hcdc
 */
public class MyAdminDetails implements UserDetails {
    
     private Admin a;
   
     
    public MyAdminDetails(Admin a) {
        this.a = a;
    }
    
   
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(a.getRole());
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return a.getPassword();
    }
 
    @Override
    public String getUsername() {
        return a.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
