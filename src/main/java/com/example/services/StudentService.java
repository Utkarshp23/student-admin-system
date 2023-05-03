/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.entities.Student;
import com.example.entities.StudentDetails;
import com.example.repositories.StudentDetailsRepository;
import com.example.repositories.StudentRepository;
import java.util.List;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hcdc
 */
@Service
@Transactional
public class StudentService {
   @PersistenceContext
    private EntityManager entityManager; 
   
   
    @Autowired
    StudentRepository strepo;
    
    @Autowired
    StudentDetailsRepository stddetrepo;
    
    
    public void saveStd(Student s)
    {
//        entityManager.merge(s);
        strepo.save(s);
    }
    
    public void saveStdDetails(StudentDetails s)
    {
//        entityManager.merge(s);
        stddetrepo.save(s);
    }
    
    public List<Student> getAllStudents()
    {
        return strepo.findAll();
    }
    
    public Page<Student> getStudsPage(int pageNumber, int pageSize)
    {
        Pageable pagea=PageRequest.of(pageNumber-1,pageSize);
        return strepo.findAll(pagea);
    }
}
