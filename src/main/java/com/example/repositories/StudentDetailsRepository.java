/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repositories;

import com.example.entities.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hcdc
 */
public interface StudentDetailsRepository extends JpaRepository<StudentDetails,Integer> {
    
}
