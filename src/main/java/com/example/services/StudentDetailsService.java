/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.entities.StudentDetails;
import com.example.repositories.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcdc
 */
@Service
public class StudentDetailsService {
    
    @Autowired 
    StudentDetailsRepository strRepo;
    
    public StudentDetails getStudentDetailsById(int id)
    {
       return strRepo.findById(id);
    }
    
}
