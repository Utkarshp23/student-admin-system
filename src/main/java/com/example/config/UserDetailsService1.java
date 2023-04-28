///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.example.config;

import com.example.entities.Admin;
import com.example.entities.Student;
import com.example.repositories.AdminRepository;
import com.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// *
// * @author hcdc
// */
public class UserDetailsService1 implements UserDetailsService {
    
    @Autowired
    private AdminRepository admRepositroy;
    
    @Autowired
    private StudentRepository stdRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Admin a = admRepositroy.getAdminByUname(username);
        Student s=stdRepository.getStudentByUname(username);
         
        if (a == null && s==null) {
            throw new UsernameNotFoundException("Could not find user");
        }else if(a==null)
        {
            return new MyStudentDetails(s);
        }
         
        return new MyAdminDetails(a);
    }
}
