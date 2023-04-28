/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repositories;

import com.example.entities.Admin;
import com.example.entities.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hcdc
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    
    @Query("select s from Student s where s.username=?1 and s.password=?2")
    public Optional<Student> getStudentByUnameAndPwd(String uname, String pwd);
    
    @Query("select s from Student s where s.username=?1")
    public Student getStudentByUname(String uname);
}
